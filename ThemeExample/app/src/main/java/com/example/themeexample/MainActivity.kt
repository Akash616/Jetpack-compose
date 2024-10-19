package com.example.themeexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.themeexample.ui.theme.ThemeExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {

            App()

            /*ThemeExampleTheme{
                Text(text = "Android",
                style = MaterialTheme.typography.bodyLarge)
            } //Kotlin feature - last parameter/trailing lambda
            ThemeExampleTheme(content = {
                    Text(text = "Android")
            })*/

        }
    }
}

@Composable
fun App() {
    //LocalConfiguration.current.
    //LocalContext.current.applicationContext
    var theme = remember { mutableStateOf(false) }
    ThemeExampleTheme(theme.value) {
        Column(
            modifier = Modifier.background(MaterialTheme.colorScheme.background)
        ) {
            Text(
                text = "Akash Gupta",
                style = MaterialTheme.typography.bodyLarge
            )
            Button(
                modifier = Modifier
                    .background(Color.Black),
                onClick = {
                    theme.value = !theme.value
                }) {
                Text(
                    text = "Change Theme",
                )
            }
        }
    }
}

