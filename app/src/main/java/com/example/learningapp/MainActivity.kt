package com.example.learningapp

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.LearningAppTheme
import kotlinx.coroutines.CoroutineScope

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var isDarkTheme by remember { mutableStateOf(false) }
            LearningAppTheme(darkTheme = isDarkTheme) {
                val scope = rememberCoroutineScope()
                val snackbarHostState = remember { SnackbarHostState() }
                Scaffold(
                    topBar = {
//                        TopAppBar(
//                            title = { Text("My App") },
//                            // The TopAppBar will typically draw behind the status bar.
//                            // Its background color will be used in the status bar area.
//                            // If you want the theme's statusBarColor to be distinctly visible
//                            // above the TopAppBar, you'd need a different structure or
//                            // make the TopAppBar itself partially transparent in that area.
//                            //
//                            // Material 3 TopAppBars often handle insets well.
//                            // You can also explicitly apply windowInsets if needed:
//                            // modifier = Modifier.windowInsetsPadding(WindowInsets.statusBars)
//                            // However, usually, you'd apply padding to the content *below* the TopAppBar.
//                            colors = TopAppBarDefaults.topAppBarColors(
//                                containerColor = MaterialTheme.colorScheme.primary, // Or your desired TopAppBar color
//                                titleContentColor = MaterialTheme.colorScheme.onPrimary
//                            )
//                        )
                    },
                    modifier = Modifier.fillMaxSize(),
                    snackbarHost = {
                        SnackbarHost(hostState = snackbarHostState)
                    }
                    ) { innerPadding ->
                    ListApp(
                        isDarkTheme = isDarkTheme,
                        onThemeChange = { newThemeState -> // Pass the lambda to update it
                            isDarkTheme = newThemeState
                        },
                        scope = scope,
                        snackbarHostState = snackbarHostState,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ListApp(
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

@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "DefaultPreviewDark"
)
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    name = "DefaultPreviewLight"
)
@Composable
fun GreetingPreview() {
    LearningAppTheme {
        var isDarkTheme by remember { mutableStateOf(false) }
        val scope = rememberCoroutineScope()
        val snackbarHostState = remember { SnackbarHostState() }
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            ListApp(
                isDarkTheme = isDarkTheme,
                onThemeChange = { newThemeState -> // Pass the lambda to update it
                    isDarkTheme = newThemeState
                },
                scope = scope,
                snackbarHostState = snackbarHostState,
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}