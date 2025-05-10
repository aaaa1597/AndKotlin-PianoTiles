package com.example.pianotiles

import android.app.Application
import android.media.AudioAttributes
import android.media.SoundPool
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

enum class SoundId { Do1,Re2,Mi3,Fa4,So5,La6,Si7,Do1Octave,Setengah }

class GameplayViewModel(vol: Float, app: Application) : AndroidViewModel(app) {
    /* Factoryメソッド */
    class Factory(private val volume: Float, private val app: Application) : ViewModelProvider.NewInstanceFactory() {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return GameplayViewModel(volume, app) as T
        }
    }
    /* Context */
    private val _app: Application = app
    /* スコア */
    private var _score: MutableStateFlow<Int> = MutableStateFlow(0)
    var score = _score.asStateFlow()
    /* 音量 */
    private val _volume: Float = vol
    /* TileQueue */
    var tiles: ArrayDeque<Tile> = ArrayDeque()

    fun init() {
        _score.value = 0
    }

    /* ゲーム開始準備 */
    fun getReady(level: GameLevel, screenW: Int, screenH: Int) {
        /* Tileリストを初期化 */
        tiles = MusicTiles.create(level, screenW, screenH)
    }
}