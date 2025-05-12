package com.example.pianotiles

import android.app.Activity
import android.media.MediaPlayer

class Jukebox(activity: Activity) {
    /* MusicPlayerクラス(外には見せない) */
    private class AaaMusicPlayer(activity: Activity, id: Int, val name: String) {
        val _id = id
        val mediaPlayer:MediaPlayer = MediaPlayer.create(activity, id)

        companion object {
            fun create(activity: Activity, id: Int, name: String): AaaMusicPlayer {
                return AaaMusicPlayer(activity, id, name)
            }
        }
    }
    private var _musicPlayers: ArrayList<AaaMusicPlayer> = arrayListOf(
        AaaMusicPlayer.create(activity, R.raw.aine, "アイネ・クライネ・ナハトムジーク").apply { mediaPlayer.setOnCompletionListener { it.start() } },
        AaaMusicPlayer.create(activity, R.raw.borero_1596, "ボレロ")                   .apply { mediaPlayer.setOnCompletionListener { it.start() } },
        AaaMusicPlayer.create(activity, R.raw.yasoukyoku, "夜想曲")                    .apply { mediaPlayer.setOnCompletionListener { it.start() } },
        AaaMusicPlayer.create(activity, R.raw.gsenjounoaria, "G線上のマリア")          .apply { mediaPlayer.setOnCompletionListener { it.start() } },
        AaaMusicPlayer.create(activity, R.raw.ifudoudou_644, "威風堂々")               .apply { mediaPlayer.setOnCompletionListener { it.start() } },
        AaaMusicPlayer.create(activity, R.raw.kirakiraboshi, "キラキラ星")             .apply { mediaPlayer.setOnCompletionListener { it.start() } },
        AaaMusicPlayer.create(activity, R.raw.hisou, "悲愴")                           .apply { mediaPlayer.setOnCompletionListener { it.start() } },
        AaaMusicPlayer.create(activity, R.raw.syuyo, "主よ人の恵みの喜びよ")           .apply { mediaPlayer.setOnCompletionListener { it.start() } },
        AaaMusicPlayer.create(activity, R.raw.tsukinohikari, "月の光")                 .apply { mediaPlayer.setOnCompletionListener { it.start() } },
        AaaMusicPlayer.create(activity, R.raw.jupitor, "ジュピター")                   .apply { mediaPlayer.setOnCompletionListener { it.start() } },
        AaaMusicPlayer.create(activity, R.raw.warukyu, "ワルキューレ")                 .apply { mediaPlayer.setOnCompletionListener { it.start() } },
    )
    /* 関数 */
    fun play(idx: Int, volume: Float)
        = _musicPlayers[idx].mediaPlayer.apply { setVolume(volume, volume); start() }
    fun stop(idx: Int)
        = _musicPlayers[idx].mediaPlayer.apply { stop(); prepare() }
    fun pause(idx: Int)
        = _musicPlayers[idx].mediaPlayer.pause()
    fun resume(idx: Int)
        = _musicPlayers[idx].mediaPlayer.start()
    fun nowSongName(idx: Int): String
        = _musicPlayers[idx].name
    fun setVolume(idx: Int, volume: Float)
        = _musicPlayers[idx].mediaPlayer.setVolume(volume, volume)
    fun numofSong(): Int
        = _musicPlayers.size
    fun init()
        = play(0, 1f)
}
