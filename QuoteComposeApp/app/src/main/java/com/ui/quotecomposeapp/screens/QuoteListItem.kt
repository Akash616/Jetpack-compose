package com.ui.quotecomposeapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ui.quotecomposeapp.R
import com.ui.quotecomposeapp.models.Quote


@Composable
fun QuoteListItem(quote: Quote, onClick: (quote: Quote) -> Unit) {
    Card(
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(Color.White),
        modifier = Modifier
            .clickable { onClick(quote) }
            .padding(8.dp)
        ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Image(
                imageVector = Icons.Filled.FormatQuote,
                contentDescription = "Quote",
                colorFilter = ColorFilter.tint(Color.White),
                alignment = Alignment.TopStart,
                modifier = Modifier
                    .size(40.dp)
                    .rotate(180f)
                    .background(Color.Black)
            )
            Spacer(
                modifier = Modifier
                    .padding(4.dp)
                    .background(Color.DarkGray)
            )
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = quote.quote,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleSmall,
                    modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 8.dp)
                )
                Box(
                    modifier = Modifier
                        .background(Color(0xFFEEEEEE))
                        .fillMaxWidth(.4f) //40% hi space lena hai
                        .height(1.dp)
                )
                Text(
                    text = quote.author,
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.W400,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
        }
    }
}