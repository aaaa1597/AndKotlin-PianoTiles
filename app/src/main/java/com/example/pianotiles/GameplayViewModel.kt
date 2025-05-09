package com.example.pianotiles

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class GameplayViewModel(vol: Float) : ViewModel() {
    class Factory(private val volume: Float) : ViewModelProvider.NewInstanceFactory() {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return GameplayViewModel(volume) as T
        }
    }

    /* pause状態 */
    private var _pause: MutableStateFlow<Boolean> = MutableStateFlow(false)
    fun setPause(state: Boolean) { _pause.value = state }
    /* スコア */
    private var _score: MutableStateFlow<Int> = MutableStateFlow(0)
    var score = _score.asStateFlow()
    /* 音量 */
    private val _volume: Float = vol

    fun init() {
        _pause.value = false
        _score.value = 0
    }
}