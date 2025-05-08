package com.example.pianotiles

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class GameplayViewModel : ViewModel() {
    /* pause状態 */
    private var _pause: MutableStateFlow<Boolean> = MutableStateFlow(false)
    fun setPause(state: Boolean) { _pause.value = true }
    /* スコア */
    private var _score: MutableStateFlow<Int> = MutableStateFlow(0)
    var score = _score.asStateFlow()

    fun init() {
        _pause.value = false
        _score.value = 0
    }
}