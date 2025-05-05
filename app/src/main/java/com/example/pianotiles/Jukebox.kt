package com.example.pianotiles

import android.app.Activity
import android.media.MediaPlayer

class Jukebox(activity: Activity) {
    /* MusicPlayerクラス(外には見せない) */
    private class AaaMusicPlayer(activity: Activity, id: Int, name: String) {
        val _id = id
        val _mediaPlayser:MediaPlayer = MediaPlayer.create(activity, R.raw.jingle_bells)
        val _name = name
        companion object {
            fun create(activity: Activity, id: Int, name: String): AaaMusicPlayer {
                return AaaMusicPlayer(activity, id, name)
            }
        }
    }
    private var _musicPlayers: ArrayList<AaaMusicPlayer> = arrayListOf(
        AaaMusicPlayer.create(activity, R.raw.jingle_bells, "Jingle Bell")                   .apply { _mediaPlayser.setOnCompletionListener { it.start() } },
        AaaMusicPlayer.create(activity, R.raw.silent_night, "Silent Night")                  .apply { _mediaPlayser.setOnCompletionListener { it.start() } },
        AaaMusicPlayer.create(activity, R.raw.last_christmas, "Last Christmas")              .apply { _mediaPlayser.setOnCompletionListener { it.start() } },
        AaaMusicPlayer.create(activity, R.raw.xia_yu_tian, "雨の日")                          .apply { _mediaPlayser.setOnCompletionListener { it.start() } },
        AaaMusicPlayer.create(activity, R.raw.hui_bu_hui, "そうか")                           .apply { _mediaPlayser.setOnCompletionListener { it.start() } },
        AaaMusicPlayer.create(activity, R.raw.tian_wai_lai_wu, "地球外物体")                   .apply { _mediaPlayser.setOnCompletionListener { it.start() } },
        AaaMusicPlayer.create(activity, R.raw.hou_lai_yu_jian_ta, "彼に会った")                .apply { _mediaPlayser.setOnCompletionListener { it.start() } },
        AaaMusicPlayer.create(activity, R.raw.xiao_zhang, "傲慢")                             .apply { _mediaPlayser.setOnCompletionListener { it.start() } },
        AaaMusicPlayer.create(activity, R.raw.yu_wo_wu_guan, "関係ない")                       .apply { _mediaPlayser.setOnCompletionListener { it.start() } },
        AaaMusicPlayer.create(activity, R.raw.fei_niao_he_chan, "鳥と蝉")                     .apply { _mediaPlayser.setOnCompletionListener { it.start() } },
        AaaMusicPlayer.create(activity, R.raw.all_i_want_for_christmas_is_you, "Christmas")  .apply { _mediaPlayser.setOnCompletionListener { it.start() } },
        AaaMusicPlayer.create(activity, R.raw.we_wish_you_merry_christmas, "Merry Christmas").apply { _mediaPlayser.setOnCompletionListener { it.start() } }
    )
    /* 関数 */
    fun play(idx: Int) { _musicPlayers[idx]._mediaPlayser.start()}
    fun stop(idx: Int) { _musicPlayers[idx]._mediaPlayser.stop() }
    fun nowSongName(idx: Int): String = _musicPlayers.get(idx)._name
    fun setVolume(idx: Int, volume: Float) {
        _musicPlayers.get(idx)._mediaPlayser.setVolume(volume, volume)
    }
}
