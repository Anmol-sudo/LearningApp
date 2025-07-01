package com.example.learningapp.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.learningapp.components.StaticList
import kotlinx.coroutines.CoroutineScope


@Composable
fun HomeScreen(
    isDarkTheme: Boolean,
    onThemeChange: (Boolean) -> Unit,
    scope: CoroutineScope,
    snackbarHostState: SnackbarHostState,
    modifier: Modifier = Modifier
) {
    StaticList(
        isDarkTheme = isDarkTheme,
        onThemeChange = onThemeChange,
        scope = scope,
        snackbarHostState = snackbarHostState,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    )
}
