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
    /* SoundIdMap */
    private lateinit var soundIdMap: Map<SoundId, Int>
    /* SoundPool */
    private lateinit var soundPool: SoundPool
    /* TileQueue */
    var tiles: ArrayDeque<Tile> = ArrayDeque()

    fun init() {
        _score.value = 0
        /* SoundPool初期化 */
        val audioAttributes = AudioAttributes.Builder()
            .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
            .setFlags(AudioAttributes.FLAG_AUDIBILITY_ENFORCED)
            .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
            .build()
        soundPool = SoundPool.Builder()
            .setMaxStreams(9)
            .setAudioAttributes(audioAttributes)
            .build()
        /* soundMap初期化 */
        soundIdMap = mapOf(
            SoundId.Do1 to soundPool.load(_app, R.raw.do_1, 1),
            SoundId.Re2 to soundPool.load(_app, R.raw.re_2, 1),
            SoundId.Mi3 to soundPool.load(_app, R.raw.mi_3, 1),
            SoundId.Fa4 to soundPool.load(_app, R.raw.fa_4, 1),
            SoundId.So5 to soundPool.load(_app, R.raw.so_5, 1),
            SoundId.La6 to soundPool.load(_app, R.raw.la_6, 1),
            SoundId.Si7 to soundPool.load(_app, R.raw.si_7, 1),
            SoundId.Do1Octave to soundPool.load(_app, R.raw.do_1_octave, 1),
            SoundId.Setengah to soundPool.load(_app, R.raw.setengah, 1),
        )

//        soundPool.play(soundMap[SoundId.si7]!!, 0.9f, 0.9f, 1, 0, 1f)
    }

    /* ゲーム開始準備 */
    fun getReady(level: GameLevel, screenW: Int, screenH: Int) {
        /* Tileリストを初期化 */
        tiles = MusicTiles.create(level, screenW, screenH)
    }

    fun destroy() {
        soundPool.release()
    }
}