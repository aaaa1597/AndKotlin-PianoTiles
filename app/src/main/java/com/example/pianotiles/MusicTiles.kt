package com.example.pianotiles

import java.util.Random

class Tile(val column: Int, val width: Float, val height: Float, val rows: Int, val soundId: Int)

class MusicTiles {
    companion object {
        var music: Array<Music> = arrayOf<Music>(
            Music(R.raw.jingle_bells, "Jingle Bell"),
            Music(R.raw.silent_night, "Silent Night"),
            Music(R.raw.last_christmas, "Last Christmas"),
            Music(R.raw.xia_yu_tian, "雨の日"),
            Music(R.raw.hui_bu_hui, "そうか"),
            Music(R.raw.tian_wai_lai_wu, "地球外物体"),
            Music(R.raw.hou_lai_yu_jian_ta, "彼に会った"),
            Music(R.raw.xiao_zhang, "傲慢"),
            Music(R.raw.yu_wo_wu_guan, "関係ない"),
            Music(R.raw.fei_niao_he_chan, "鳥と蝉"),
            Music(R.raw.all_i_want_for_christmas_is_you, "Christmas"),
            Music(R.raw.we_wish_you_merry_christmas, "Merry Christmas")
        )

        fun create(level: GameLevel, screenW: Int, screenH: Int): ArrayDeque<Tile> {
            return when(level) {
                GameLevel.easy  -> getKartini(   screenW, 4, screenH, 4)
                GameLevel.normal-> getLittleStar(screenW, 5, screenH, 4)
                GameLevel.hard  -> getMinuet(    screenW, 6, screenH, 4)
            }
        }

        private fun getKartini(screenW: Int, divW: Int, screenH: Int, divH: Int): ArrayDeque<Tile> {
            val width = screenW.toFloat() / divW.toFloat()
            val height= screenH.toFloat() / divH.toFloat()
            return ArrayDeque(listOf(
                Tile(generateRandomColumn(divW), width, height, 2, 1),
                Tile(generateRandomColumn(divW), width, height, 1, 2),
                Tile(generateRandomColumn(divW), width, height, 1, 3),
                Tile(generateRandomColumn(divW), width, height, 1, 4),
                Tile(generateRandomColumn(divW), width, height, 2, 5),
                Tile(generateRandomColumn(divW), width, height, 1, 3),
                Tile(generateRandomColumn(divW), width, height, 2, 1),
                Tile(generateRandomColumn(divW), width, height, 2, 6),
                Tile(generateRandomColumn(divW), width, height, 1, 8),
                Tile(generateRandomColumn(divW), width, height, 1, 7),
                Tile(generateRandomColumn(divW), width, height, 1, 6),
                Tile(generateRandomColumn(divW), width, height, 4, 5),
                Tile(generateRandomColumn(divW), width, height, 2, 4),
                Tile(generateRandomColumn(divW), width, height, 1, 6),
                Tile(generateRandomColumn(divW), width, height, 1, 5),
                Tile(generateRandomColumn(divW), width, height, 1, 4),
                Tile(generateRandomColumn(divW), width, height, 2, 3),
                Tile(generateRandomColumn(divW), width, height, 2, 1),
                Tile(generateRandomColumn(divW), width, height, 2, 2),
                Tile(generateRandomColumn(divW), width, height, 1, 4),
                Tile(generateRandomColumn(divW), width, height, 1, 3),
                Tile(generateRandomColumn(divW), width, height, 1, 2),
                Tile(generateRandomColumn(divW), width, height, 4, 1),
                Tile(generateRandomColumn(divW), width, height, 2, 4),
                Tile(generateRandomColumn(divW), width, height, 1, 3),
                Tile(generateRandomColumn(divW), width, height, 1, 4),
                Tile(generateRandomColumn(divW), width, height, 1, 6),
                Tile(generateRandomColumn(divW), width, height, 1, 5),
                Tile(generateRandomColumn(divW), width, height, 1, 6),
                Tile(generateRandomColumn(divW), width, height, 1, 5),
                Tile(generateRandomColumn(divW), width, height, 1, 3),
                Tile(generateRandomColumn(divW), width, height, 1, 1),
                Tile(generateRandomColumn(divW), width, height, 1, 3),
                Tile(generateRandomColumn(divW), width, height, 1, 2),
                Tile(generateRandomColumn(divW), width, height, 1, 3),
                Tile(generateRandomColumn(divW), width, height, 1, 4),
                Tile(generateRandomColumn(divW), width, height, 1, 6),
                Tile(generateRandomColumn(divW), width, height, 4, 5),
                Tile(generateRandomColumn(divW), width, height, 2, 4),
                Tile(generateRandomColumn(divW), width, height, 1, 3),
                Tile(generateRandomColumn(divW), width, height, 1, 4),
                Tile(generateRandomColumn(divW), width, height, 1, 6),
                Tile(generateRandomColumn(divW), width, height, 1, 5),
                Tile(generateRandomColumn(divW), width, height, 1, 6),
                Tile(generateRandomColumn(divW), width, height, 1, 5),
                Tile(generateRandomColumn(divW), width, height, 1, 3),
                Tile(generateRandomColumn(divW), width, height, 1, 1),
                Tile(generateRandomColumn(divW), width, height, 1, 3),
                Tile(generateRandomColumn(divW), width, height, 1, 2),
                Tile(generateRandomColumn(divW), width, height, 1, 4),
                Tile(generateRandomColumn(divW), width, height, 1, 3),
                Tile(generateRandomColumn(divW), width, height, 1, 2),
                Tile(generateRandomColumn(divW), width, height, 4, 1),
            ))
        }

        private fun getLittleStar(screenW: Int, divW: Int, screenH: Int, divH: Int): ArrayDeque<Tile> {
            val width = screenW.toFloat() / divW.toFloat()
            val height= screenH.toFloat() / divH.toFloat()
            return ArrayDeque(listOf(
                Tile(generateRandomColumn(divW), width, height,1, 1),
                Tile(generateRandomColumn(divW), width, height,1, 1),
                Tile(generateRandomColumn(divW), width, height,1, 5),
                Tile(generateRandomColumn(divW), width, height,1, 5),
                Tile(generateRandomColumn(divW), width, height,1, 6),
                Tile(generateRandomColumn(divW), width, height,1, 6),
                Tile(generateRandomColumn(divW), width, height,1, 5),
                Tile(generateRandomColumn(divW), width, height,1, 4),
                Tile(generateRandomColumn(divW), width, height,1, 4),
                Tile(generateRandomColumn(divW), width, height,1, 3),
                Tile(generateRandomColumn(divW), width, height,1, 3),
                Tile(generateRandomColumn(divW), width, height,1, 2),
                Tile(generateRandomColumn(divW), width, height,1, 2),
                Tile(generateRandomColumn(divW), width, height,1, 1),
                Tile(generateRandomColumn(divW), width, height,1, 5),
                Tile(generateRandomColumn(divW), width, height,1, 5),
                Tile(generateRandomColumn(divW), width, height,1, 4),
                Tile(generateRandomColumn(divW), width, height,1, 4),
                Tile(generateRandomColumn(divW), width, height,1, 3),
                Tile(generateRandomColumn(divW), width, height,1, 3),
                Tile(generateRandomColumn(divW), width, height,1, 2),
                Tile(generateRandomColumn(divW), width, height,1, 5),
                Tile(generateRandomColumn(divW), width, height,1, 5),
                Tile(generateRandomColumn(divW), width, height,1, 4),
                Tile(generateRandomColumn(divW), width, height,1, 4),
                Tile(generateRandomColumn(divW), width, height,1, 3),
                Tile(generateRandomColumn(divW), width, height,1, 3),
                Tile(generateRandomColumn(divW), width, height,1, 2),
                Tile(generateRandomColumn(divW), width, height,1, 1),
                Tile(generateRandomColumn(divW), width, height,1, 1),
                Tile(generateRandomColumn(divW), width, height,1, 5),
                Tile(generateRandomColumn(divW), width, height,1, 5),
                Tile(generateRandomColumn(divW), width, height,1, 6),
                Tile(generateRandomColumn(divW), width, height,1, 6),
                Tile(generateRandomColumn(divW), width, height,1, 5),
                Tile(generateRandomColumn(divW), width, height,1, 4),
                Tile(generateRandomColumn(divW), width, height,1, 4),
                Tile(generateRandomColumn(divW), width, height,1, 3),
                Tile(generateRandomColumn(divW), width, height,1, 3),
                Tile(generateRandomColumn(divW), width, height,1, 2),
                Tile(generateRandomColumn(divW), width, height,1, 2),
                Tile(generateRandomColumn(divW), width, height,1, 1),
           ))
        }

        private fun getMinuet(screenW: Int, divW: Int, screenH: Int, divH: Int): ArrayDeque<Tile> {
            val width = screenW.toFloat() / divW.toFloat()
            val height= screenH.toFloat() / divH.toFloat()
            return ArrayDeque(listOf(
		        Tile(generateRandomColumn(divW), width, height, 1, 5),
		        Tile(generateRandomColumn(divW), width, height, 1, 1),
		        Tile(generateRandomColumn(divW), width, height, 1, 2),
		        Tile(generateRandomColumn(divW), width, height, 1, 3),
		        Tile(generateRandomColumn(divW), width, height, 1, 4),
		        Tile(generateRandomColumn(divW), width, height, 1, 5),
		        Tile(generateRandomColumn(divW), width, height, 1, 1),
		        Tile(generateRandomColumn(divW), width, height, 1, 1),
		        Tile(generateRandomColumn(divW), width, height, 1, 6),
		        Tile(generateRandomColumn(divW), width, height, 1, 4),
		        Tile(generateRandomColumn(divW), width, height, 1, 5),
		        Tile(generateRandomColumn(divW), width, height, 1, 6),
		        Tile(generateRandomColumn(divW), width, height, 1, 7),
		        Tile(generateRandomColumn(divW), width, height, 1, 8),
		        Tile(generateRandomColumn(divW), width, height, 1, 1),
		        Tile(generateRandomColumn(divW), width, height, 1, 1),
		        Tile(generateRandomColumn(divW), width, height, 1, 4),
		        Tile(generateRandomColumn(divW), width, height, 1, 5),
		        Tile(generateRandomColumn(divW), width, height, 1, 4),
		        Tile(generateRandomColumn(divW), width, height, 1, 3),
		        Tile(generateRandomColumn(divW), width, height, 1, 2),
		        Tile(generateRandomColumn(divW), width, height, 1, 3),
		        Tile(generateRandomColumn(divW), width, height, 1, 4),
		        Tile(generateRandomColumn(divW), width, height, 1, 3),
		        Tile(generateRandomColumn(divW), width, height, 1, 2),
		        Tile(generateRandomColumn(divW), width, height, 1, 1),
		        Tile(generateRandomColumn(divW), width, height, 1, 2),
		        Tile(generateRandomColumn(divW), width, height, 1, 3),
		        Tile(generateRandomColumn(divW), width, height, 1, 2),
		        Tile(generateRandomColumn(divW), width, height, 1, 1),
		        Tile(generateRandomColumn(divW), width, height, 1, 2),
		        Tile(generateRandomColumn(divW), width, height, 1, 1),
            ))
        }

        private fun generateRandomColumn(upperBound: Int): Int {
            val rand = Random()
            return rand.nextInt(upperBound)
        }

    }
}