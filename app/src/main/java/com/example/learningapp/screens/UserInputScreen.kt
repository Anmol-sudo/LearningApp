package com.example.learningapp.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun UserInputScreen(){
    var text = remember { mutableStateOf("") }
    var context = LocalContext.current
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = text.value,
            onValueChange = {newText ->
                if(newText.length < 11){
                    text.value = newText
                }
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            "I will update as you type: ${text.value}"
        )
        Button(
            onClick = {
                text.value = ""
                Toast.makeText(context, "Text Cleared", Toast.LENGTH_SHORT).show()
            }
        ) {
            Text("Reset Text")
        }
    }
}