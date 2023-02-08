package com.example.typingstate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import com.example.typingstate.ui.theme.TypingStateTheme

class MainActivity : ComponentActivity() {

    val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TypingStateTheme {
                TypingStateScreen()
            }
        }
    }

    @Composable
    private fun TypingStateScreen() {

        var text by remember {
            mutableStateOf("")
        }

        Column() {

            Text(
                text = if (viewModel.isTyping.value) "Is typing" else "Is not typing"
            )

            TextField(
                value = text,
                onValueChange = {
                    viewModel.typing()
                    text = it
                }
            )
        }
    }
}




