package com.ui.firstcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            //PreviewItem()
            NotificationScreen2()
        }
    }
}


@Composable
private fun PreviewFunction() {
    Text(
        text = "Akash Gupta",
        color = Color.White,
        //In modifier sequence matters here
        modifier = Modifier
            .clickable { }
            .background(Color.Blue)
            .padding(20.dp)
            .size(200.dp)
            .border(4.dp, color = Color.Red)
            .clip(CircleShape)
            .background(Color.Yellow)
    )
}


@Composable
fun CircularImage(){
    Image(painter = painterResource(id = R.drawable.ic_launcher_background),
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(80.dp)
            .clip(CircleShape)
            .border(2.dp, Color.LightGray, CircleShape),
        contentDescription = "")
}

@Composable
fun ListViewItem(imgId: Int, name: String, occupation: String, modifier: Modifier) {
    Row(modifier.padding(8.dp)) {
        Image(
            painter = painterResource(id = imgId),
            contentDescription = "",
            modifier = Modifier.size(40.dp) //Image size
        )
        Column {
            Text(
                text = name,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = occupation,
                fontWeight = FontWeight.Thin,
                fontSize = 12.sp
            )
        }
    }
}

@Composable
fun TextInput() {
    val state = remember { mutableStateOf("") }
    TextField(
        value = state.value,
        onValueChange = {
            state.value = it
        },
        label = { Text(text = "Enter message") },
        isError = true
    )
}