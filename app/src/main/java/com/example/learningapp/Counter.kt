package com.example.learningapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Counter() {
    var count = remember { mutableIntStateOf(0) }
    Column(
        modifier = Modifier
            .padding(64.dp)
            .background(Color.LightGray)
    ) {
        Text(
            text = "Counter value: ${count.intValue}"
        )
        Button(onClick = {
            count.intValue++
        }) {
            Text("Increase Timer")
        }
        Button(onClick = {
            if(count.intValue > 0){
                count.intValue--
            }
        }) {
            Text("Decrease Timer")
        }
        Button(onClick = {
            count.intValue = 0
        }) {
            Text("Reset Timer")
        }
    }
}