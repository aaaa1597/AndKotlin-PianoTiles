package com.example.pianotiles

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlin.math.ln

class MainMenuViewModel : ViewModel() {
    /* ミュート設定 */
    private val _mute: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val mute = _mute.asStateFlow()
    fun toggleMute() {
        _mute.value = !_mute.value
        if(_mute.value)
            _jukebox.value.setVolume(nowidx.value, 0f)
        else
            _jukebox.value.setVolume(nowidx.value, volume.value)
    }

    /* ボリューム設定 */
    private val _volume: MutableStateFlow<Float> = MutableStateFlow(1f)
    val volume = _volume.asStateFlow()
    fun changeVolume(seekbarval: Int/*引数: 0..100*/) {
        _seekbarval = seekbarval
        /* 引数0..100, 出力0f..1f */
        var vol = (1 - ln((100 - seekbarval).toDouble()) / ln(100.0)).toFloat()
        if (java.lang.Double.isInfinite(vol.toDouble())) {
            vol = 1f
        }
        _volume.value = vol
        _jukebox.value.setVolume(_nowidx.value, vol)
    }
    /* 音量調整バーの値 */
    private var _seekbarval: Int = 100
    fun getSeekbarValue(): Int = _seekbarval

    /* 難易度設定 */
    private val _level: MutableStateFlow<GameLevel> = MutableStateFlow(GameLevel.easy)
    val level = _level.asStateFlow()
    fun getLevel() = level.value
    fun setLevel(level: GameLevel) { _level.value = level }
    /* 楽曲再生 */
    private val _nowidx: MutableStateFlow<Int> = MutableStateFlow(0)
    val nowidx = _nowidx.asStateFlow()
    fun nextSong() {
        _jukebox.value.stop(_nowidx.value)
        _nowidx.value++
        if(_nowidx.value >= _jukebox.value.numofSong()-1)
            _nowidx.value = 0
        _jukebox.value.play(nowidx.value, volume.value)
    }
    private lateinit var _jukebox: MutableStateFlow<Jukebox>
    fun setJukebox(jukebox: Jukebox) { _jukebox = MutableStateFlow(jukebox) }
    fun getNowSongName() = _jukebox.value.nowSongName(nowidx.value)
    fun playSong() = _jukebox.value.play(nowidx.value, volume.value)
    fun stopSong() = _jukebox.value.stop(nowidx.value)
    fun pauseSong() = _jukebox.value.pause(nowidx.value)
    fun resumeSong() { _jukebox.value.resume(nowidx.value)}

    /* 初期値に戻す */
    fun init() {
        _mute.value = false
        _volume.value = 1f
        _level.value = GameLevel.easy
        _jukebox.value.stop(nowidx.value)
        _nowidx.value = 0
        _seekbarval = 100
        _jukebox.value.init()
    }
}