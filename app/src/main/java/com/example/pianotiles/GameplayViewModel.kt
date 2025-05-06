package com.example.pianotiles

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class GameplayViewModel : ViewModel() {
    private var _pause: MutableStateFlow<Boolean> = MutableStateFlow(false)
    fun setPause(state: Boolean) { _pause.value = true }

    fun init() {
        _pause.value = false
    }
}