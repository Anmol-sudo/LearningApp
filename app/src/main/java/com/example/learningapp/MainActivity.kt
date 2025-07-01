package com.example.learningapp

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.example.compose.LearningAppTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var isDarkTheme by remember { mutableStateOf(false) }
            LearningAppTheme(darkTheme = isDarkTheme) {
                App(
                    isDarkTheme = isDarkTheme,
                    onThemeChange = { newThemeState ->
                        isDarkTheme = newThemeState
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    var isDarkTheme by remember { mutableStateOf(false) }
    LearningAppTheme(darkTheme = isDarkTheme) {
        App(
            isDarkTheme = isDarkTheme,
            onThemeChange = { newThemeState ->
                isDarkTheme = newThemeState
            }
        )
    }
}