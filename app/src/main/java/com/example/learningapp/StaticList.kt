package com.example.learningapp

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun StaticList(
    scope: CoroutineScope,
    snackbarHostState: SnackbarHostState,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val textValue = remember { mutableStateOf("") }
    val items = remember { mutableStateListOf<String>(
        "Maria",
        "John",
        "Mary",
        "Jason",
        "Tulip"
    ) }
    val undoValue = remember { mutableStateOf("") }



    fun addItem(itemId: String = ""){
        if(itemId.length > 1) {
            items.add(itemId)
            return
        }

        val entry = textValue.value
        items.add(entry)

        scope.launch {
            snackbarHostState.showSnackbar(
                message = "$entry got added",
                actionLabel = "Dismiss" // Optional action button
            )
        }
//        Toast.makeText(context, "${textValue.value} got added", Toast.LENGTH_SHORT).show()
        textValue.value = ""
    }

    fun undoItem(undoItemValue: String){
        addItem(undoItemValue)
    }

    fun removeItem(itemTitle: String){
        items.remove(itemTitle)
        undoValue.value = itemTitle
    }

    LazyColumn(modifier = modifier) {
        items(items) { item ->
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.tertiary,
                ),modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .combinedClickable(
                        onClick = {
                            scope.launch {
                                snackbarHostState.showSnackbar(
                                    message = "You clicked on $item",
                                    actionLabel = "Dismiss" // Optional action button
                                )
                            }
//                            Toast.makeText(context, item, Toast.LENGTH_SHORT).show()
                        },
                        onLongClick = {
                            removeItem(item)
                            scope.launch {
                                val result = snackbarHostState.showSnackbar(
                                    message = "Item deleted",  // The main message
                                    actionLabel = "UNDO",      // This sets the text of the action button
                                    duration = SnackbarDuration.Long // Or the duration you need
                                )

                                // Handle the result to perform the undo action if the user clicks "UNDO"
                                when (result) {
                                    SnackbarResult.ActionPerformed -> {
                                        // Your undo logic goes here (e.g., restore the deleted item)
                                        undoItem(undoValue.value)
                                        undoValue.value = ""
                                    }
                                    SnackbarResult.Dismissed -> {
                                        // Handle Snackbar dismissed without action (optional)
                                    }
                                }
                            }
//                            Toast.makeText(context, "$item got deleted", Toast.LENGTH_SHORT).show()
                        }
                    )
            ) {
                Text(item, modifier = Modifier.padding(16.dp))
            }
        }
        item {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(12.dp))
                TextField(
                    value = textValue.value,
                    onValueChange = { newText -> textValue.value = newText }
                )
                Spacer(modifier = Modifier.height(12.dp))
                Button(
                    onClick = {
                        addItem()
                    }
                ) {
                    Text("Add Items")
                }
            }
        }
    }

}