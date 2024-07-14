package com.ui.quotecomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.ui.quotecomposeapp.screens.QuoteDetailScreen
import com.ui.quotecomposeapp.screens.QuoteListScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge() full screen mode
        //DataManager.loadAssetsFromFile(this) //right now it's in main thread
        CoroutineScope(Dispatchers.IO).launch {
            //Background thread
            //delay(10000) //for testing purpose
            DataManager.loadAssetsFromFile(applicationContext)
        }
        setContent {
           App()
        }
    }
}

@Composable
fun App() {
    if (DataManager.isDataLoaded.value){

        if (DataManager.currentPage.value == Pages.LISTING){
            QuoteListScreen(quote = DataManager.data) {
                DataManager.switchPages(it)
            }
        }else{
            DataManager.currentQuote?.let { QuoteDetailScreen(quote = it) }
        }


    } else {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize(1f)
        ){
            Text(text = "Loading...",
                color = Color.Black,
                style = MaterialTheme.typography.headlineSmall)
        }
    }
}

enum class Pages{
    LISTING,
    DETAIL
}

