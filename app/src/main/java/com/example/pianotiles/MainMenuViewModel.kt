package com.example.pianotiles

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlin.math.ln

class MainMenuViewModel : ViewModel() {
    /* ミュート設定 */
    private val _mute: MutableStateFlow<Boolean> = MutableStateFlow<Boolean>(false)
    val mute = _mute.asStateFlow()
    fun isMute(): Boolean = mute.value
    fun toggleMute() {
        _mute.value = !_mute.value
    }

    /* ボリューム設定 */
    private val _volume: MutableStateFlow<Float> = MutableStateFlow<Float>(1f)
    private val volume = _volume.asStateFlow()
    fun getVolume(): Float = volume.value
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
    private val level = _level.asStateFlow()
    fun getLevel() = level.value
    fun setLevel(level: Int) { _level.value = level }
    /* 楽曲再生 */
    private val _nowidx: MutableStateFlow<Int> = MutableStateFlow<Int>(0)
    private val nowidx = _nowidx.asStateFlow()
    private lateinit var _jukebox: MutableStateFlow<Jukebox>
    fun setJukebox(jukebox: Jukebox) { _jukebox = MutableStateFlow(jukebox) }
    fun getNowSongName() = _jukebox.value.nowSongName(nowidx.value)
    fun playSong() = _jukebox.value.play(nowidx.value)
    fun stopSong() = _jukebox.value.stop(nowidx.value)

    /* 初期値に戻す */
    fun init() {
        _mute.value = false
        _volume.value = 50f
        _level.value = 1
        _jukebox.value.stop(nowidx.value)
        _nowidx.value = 0
    }
}