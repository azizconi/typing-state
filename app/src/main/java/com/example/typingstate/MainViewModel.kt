package com.example.typingstate

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    val isTyping = mutableStateOf(false)


    fun typing() {
        viewModelScope.launch {
            isTyping.value = true
            delay(2000)
            isTyping.value = false
        }
    }

}