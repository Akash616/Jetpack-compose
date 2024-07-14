package com.ui.firstcompose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun NotificationScreen(){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize(1f)
    ) {
        NotificationCounter()
    }
}

@Composable
fun NotificationCounter() {
    //var count: MutableState<Int> = remember { mutableIntStateOf(0) } //losses value in configuration changes
    var count: MutableState<Int> = rememberSaveable { mutableIntStateOf(0) } //solution for configuration changes
    //rememberSaveable -> store in BUNDLE(onCreate(savedInstanceState: Bundle?))
    //for store custom(class) use parcelable/serializable to store in bundle.
    //we have viewmodel fot configuration changes but i don't want to use
    //we use rememberSaveable
    Column(
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "You have sent ${count.value} notifications")
        Button(onClick = { count.value++ }) {
            Text(text = "Send Notification")
        }
    }
}
