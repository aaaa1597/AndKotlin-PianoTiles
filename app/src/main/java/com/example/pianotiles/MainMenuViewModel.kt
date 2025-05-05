package com.example.pianotiles

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.runBlocking
import kotlin.math.ln

class MainMenuViewModel : ViewModel() {
    /* ミュート設定 */
    private val _mute: MutableStateFlow<Boolean> = MutableStateFlow<Boolean>(false)
    val mute = _mute.asStateFlow()
    fun isMute(): Boolean = _mute.value
    /* ボリューム */
    private val _volume: MutableStateFlow<Float> = MutableStateFlow<Float>(1f)
    val volume = _volume.asStateFlow()
    fun getVolume(): Float = _volume.value
    fun setVolume(volume: Float): Float {
        var vol = (1 - ln((100 - volume).toDouble()) / ln(100.0)).toFloat()
        if (java.lang.Double.isInfinite(vol.toDouble())) {
            vol = 1f
        }
        _volume.value = vol
        return vol
    }
    /* ゲーム難易度 */
    private val _level: MutableStateFlow<Int> = MutableStateFlow<Int>(1)

    fun init() {
        _level.value = 1
        _mute.value = false
    }

    fun toggleMute() {
        _mute.value = !_mute.value
    }

    fun setLevel(level: Int) {
        _level.value = level
    }
}