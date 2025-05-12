package com.example.pianotiles

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class GameplayViewModel(vol: Float, app: Application) : AndroidViewModel(app) {
    /* Factoryメソッド */
    class Factory(private val volume: Float, private val app: Application) : ViewModelProvider.NewInstanceFactory() {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return GameplayViewModel(volume, app) as T
        }
    }
    /* スコア */
    var _score: MutableStateFlow<Int> = MutableStateFlow(0)
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