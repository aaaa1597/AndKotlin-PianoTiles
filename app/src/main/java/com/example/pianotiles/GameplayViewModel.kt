package com.example.pianotiles

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.flow.MutableStateFlow

class GameplayViewModel(app: Application) : AndroidViewModel(app) {
    /* Factoryメソッド */
    class Factory(private val app: Application) : ViewModelProvider.NewInstanceFactory() {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return GameplayViewModel(app) as T
        }
    }
    /* スコア */
    var score: MutableStateFlow<Int> = MutableStateFlow(0)
    /* TileQueue */
    var tiles: ArrayDeque<Tile> = ArrayDeque()

    /* ゲーム開始準備 */
    fun getReady(level: GameLevel, screenW: Int, screenH: Int) {
        /* Tileリストを初期化 */
        tiles = MusicTiles.create(level, screenW, screenH)
    }
}