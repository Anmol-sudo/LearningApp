package com.example.learningapp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.compose.LearningAppTheme
import com.example.learningapp.screens.ContactsScreen
import com.example.learningapp.screens.CounterScreen
import com.example.learningapp.screens.HomeScreen
import com.example.learningapp.screens.UserInputScreen

@Composable
fun App(isDarkTheme: Boolean,onThemeChange: (Boolean) -> Unit) {
        val scope = rememberCoroutineScope()
        val snackbarHostState = remember { SnackbarHostState() }
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            snackbarHost = {
                SnackbarHost(hostState = snackbarHostState)
            }
        ) { innerPadding ->
            val navController = rememberNavController()
            NavHost(modifier = Modifier.padding(innerPadding), navController = navController, startDestination = "home_screen", builder = {
                composable("home_screen") {
                    HomeScreen(
                        navController = navController,
                        isDarkTheme = isDarkTheme,     // Pass the current state down
                        onThemeChange = onThemeChange,
                        scope = scope,
                        snackbarHostState = snackbarHostState,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
                composable("counter_screen") {
                    CounterScreen()
                }
                composable("user_screen") {
                    UserInputScreen()
                }
                composable("contacts_screen") {
                    ContactsScreen()
                }
            })

        }

}
