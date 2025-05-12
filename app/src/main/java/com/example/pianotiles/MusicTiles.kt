package com.example.pianotiles

import java.util.Random

class Tile(val column: Int, val width: Float, val height: Float, val rows: Int, val resId: Int)

class MusicTiles {
    companion object {
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
                Tile(generateRandomColumn(divW), width, height, 2, R.raw.do_1),
                Tile(generateRandomColumn(divW), width, height, 1, R.raw.re_2),
                Tile(generateRandomColumn(divW), width, height, 1, R.raw.mi_3),
                Tile(generateRandomColumn(divW), width, height, 1, R.raw.fa_4),
                Tile(generateRandomColumn(divW), width, height, 2, R.raw.so_5),
                Tile(generateRandomColumn(divW), width, height, 1, R.raw.mi_3),
                Tile(generateRandomColumn(divW), width, height, 2, R.raw.do_1),
                Tile(generateRandomColumn(divW), width, height, 2, R.raw.la_6),
                Tile(generateRandomColumn(divW), width, height, 1, R.raw.do_1_octave),
                Tile(generateRandomColumn(divW), width, height, 1, R.raw.si_7),
                Tile(generateRandomColumn(divW), width, height, 1, R.raw.la_6),
                Tile(generateRandomColumn(divW), width, height, 4, R.raw.so_5),
                Tile(generateRandomColumn(divW), width, height, 2, R.raw.fa_4),
                Tile(generateRandomColumn(divW), width, height, 1, R.raw.la_6),
                Tile(generateRandomColumn(divW), width, height, 1, R.raw.so_5),
                Tile(generateRandomColumn(divW), width, height, 1, R.raw.fa_4),
                Tile(generateRandomColumn(divW), width, height, 2, R.raw.mi_3),
                Tile(generateRandomColumn(divW), width, height, 2, R.raw.do_1),
                Tile(generateRandomColumn(divW), width, height, 2, R.raw.re_2),
                Tile(generateRandomColumn(divW), width, height, 1, R.raw.fa_4),
                Tile(generateRandomColumn(divW), width, height, 1, R.raw.mi_3),
                Tile(generateRandomColumn(divW), width, height, 1, R.raw.re_2),
                Tile(generateRandomColumn(divW), width, height, 4, R.raw.do_1),
                Tile(generateRandomColumn(divW), width, height, 2, R.raw.fa_4),
                Tile(generateRandomColumn(divW), width, height, 1, R.raw.mi_3),
                Tile(generateRandomColumn(divW), width, height, 1, R.raw.fa_4),
                Tile(generateRandomColumn(divW), width, height, 1, R.raw.la_6),
                Tile(generateRandomColumn(divW), width, height, 1, R.raw.so_5),
                Tile(generateRandomColumn(divW), width, height, 1, R.raw.la_6),
                Tile(generateRandomColumn(divW), width, height, 1, R.raw.so_5),
                Tile(generateRandomColumn(divW), width, height, 1, R.raw.mi_3),
                Tile(generateRandomColumn(divW), width, height, 1, R.raw.do_1),
                Tile(generateRandomColumn(divW), width, height, 1, R.raw.mi_3),
                Tile(generateRandomColumn(divW), width, height, 1, R.raw.re_2),
                Tile(generateRandomColumn(divW), width, height, 1, R.raw.mi_3),
                Tile(generateRandomColumn(divW), width, height, 1, R.raw.fa_4),
                Tile(generateRandomColumn(divW), width, height, 1, R.raw.la_6),
                Tile(generateRandomColumn(divW), width, height, 4, R.raw.so_5),
                Tile(generateRandomColumn(divW), width, height, 2, R.raw.fa_4),
                Tile(generateRandomColumn(divW), width, height, 1, R.raw.mi_3),
                Tile(generateRandomColumn(divW), width, height, 1, R.raw.fa_4),
                Tile(generateRandomColumn(divW), width, height, 1, R.raw.la_6),
                Tile(generateRandomColumn(divW), width, height, 1, R.raw.so_5),
                Tile(generateRandomColumn(divW), width, height, 1, R.raw.la_6),
                Tile(generateRandomColumn(divW), width, height, 1, R.raw.so_5),
                Tile(generateRandomColumn(divW), width, height, 1, R.raw.mi_3),
                Tile(generateRandomColumn(divW), width, height, 1, R.raw.do_1),
                Tile(generateRandomColumn(divW), width, height, 1, R.raw.mi_3),
                Tile(generateRandomColumn(divW), width, height, 1, R.raw.re_2),
                Tile(generateRandomColumn(divW), width, height, 1, R.raw.fa_4),
                Tile(generateRandomColumn(divW), width, height, 1, R.raw.mi_3),
                Tile(generateRandomColumn(divW), width, height, 1, R.raw.re_2),
                Tile(generateRandomColumn(divW), width, height, 4, R.raw.do_1),
            ))
        }

        private fun getLittleStar(screenW: Int, divW: Int, screenH: Int, divH: Int): ArrayDeque<Tile> {
            val width = screenW.toFloat() / divW.toFloat()
            val height= screenH.toFloat() / divH.toFloat()
            return ArrayDeque(listOf(
                Tile(generateRandomColumn(divW), width, height,1, R.raw.do_1),
                Tile(generateRandomColumn(divW), width, height,1, R.raw.do_1),
                Tile(generateRandomColumn(divW), width, height,1, R.raw.so_5),
                Tile(generateRandomColumn(divW), width, height,1, R.raw.so_5),
                Tile(generateRandomColumn(divW), width, height,1, R.raw.la_6),
                Tile(generateRandomColumn(divW), width, height,1, R.raw.la_6),
                Tile(generateRandomColumn(divW), width, height,1, R.raw.so_5),
                Tile(generateRandomColumn(divW), width, height,1, R.raw.fa_4),
                Tile(generateRandomColumn(divW), width, height,1, R.raw.fa_4),
                Tile(generateRandomColumn(divW), width, height,1, R.raw.mi_3),
                Tile(generateRandomColumn(divW), width, height,1, R.raw.mi_3),
                Tile(generateRandomColumn(divW), width, height,1, R.raw.re_2),
                Tile(generateRandomColumn(divW), width, height,1, R.raw.re_2),
                Tile(generateRandomColumn(divW), width, height,1, R.raw.do_1),
                Tile(generateRandomColumn(divW), width, height,1, R.raw.so_5),
                Tile(generateRandomColumn(divW), width, height,1, R.raw.so_5),
                Tile(generateRandomColumn(divW), width, height,1, R.raw.fa_4),
                Tile(generateRandomColumn(divW), width, height,1, R.raw.fa_4),
                Tile(generateRandomColumn(divW), width, height,1, R.raw.mi_3),
                Tile(generateRandomColumn(divW), width, height,1, R.raw.mi_3),
                Tile(generateRandomColumn(divW), width, height,1, R.raw.re_2),
                Tile(generateRandomColumn(divW), width, height,1, R.raw.so_5),
                Tile(generateRandomColumn(divW), width, height,1, R.raw.so_5),
                Tile(generateRandomColumn(divW), width, height,1, R.raw.fa_4),
                Tile(generateRandomColumn(divW), width, height,1, R.raw.fa_4),
                Tile(generateRandomColumn(divW), width, height,1, R.raw.mi_3),
                Tile(generateRandomColumn(divW), width, height,1, R.raw.mi_3),
                Tile(generateRandomColumn(divW), width, height,1, R.raw.re_2),
                Tile(generateRandomColumn(divW), width, height,1, R.raw.do_1),
                Tile(generateRandomColumn(divW), width, height,1, R.raw.do_1),
                Tile(generateRandomColumn(divW), width, height,1, R.raw.so_5),
                Tile(generateRandomColumn(divW), width, height,1, R.raw.so_5),
                Tile(generateRandomColumn(divW), width, height,1, R.raw.la_6),
                Tile(generateRandomColumn(divW), width, height,1, R.raw.la_6),
                Tile(generateRandomColumn(divW), width, height,1, R.raw.so_5),
                Tile(generateRandomColumn(divW), width, height,1, R.raw.fa_4),
                Tile(generateRandomColumn(divW), width, height,1, R.raw.fa_4),
                Tile(generateRandomColumn(divW), width, height,1, R.raw.mi_3),
                Tile(generateRandomColumn(divW), width, height,1, R.raw.mi_3),
                Tile(generateRandomColumn(divW), width, height,1, R.raw.re_2),
                Tile(generateRandomColumn(divW), width, height,1, R.raw.re_2),
                Tile(generateRandomColumn(divW), width, height,1, R.raw.do_1),
           ))
        }

        private fun getMinuet(screenW: Int, divW: Int, screenH: Int, divH: Int): ArrayDeque<Tile> {
            val width = screenW.toFloat() / divW.toFloat()
            val height= screenH.toFloat() / divH.toFloat()
            return ArrayDeque(listOf(
		        Tile(generateRandomColumn(divW), width, height, 1, R.raw.so_5),
		        Tile(generateRandomColumn(divW), width, height, 1, R.raw.do_1),
		        Tile(generateRandomColumn(divW), width, height, 1, R.raw.re_2),
		        Tile(generateRandomColumn(divW), width, height, 1, R.raw.mi_3),
		        Tile(generateRandomColumn(divW), width, height, 1, R.raw.fa_4),
		        Tile(generateRandomColumn(divW), width, height, 1, R.raw.so_5),
		        Tile(generateRandomColumn(divW), width, height, 1, R.raw.do_1),
		        Tile(generateRandomColumn(divW), width, height, 1, R.raw.do_1),
		        Tile(generateRandomColumn(divW), width, height, 1, R.raw.la_6),
		        Tile(generateRandomColumn(divW), width, height, 1, R.raw.fa_4),
		        Tile(generateRandomColumn(divW), width, height, 1, R.raw.so_5),
		        Tile(generateRandomColumn(divW), width, height, 1, R.raw.la_6),
		        Tile(generateRandomColumn(divW), width, height, 1, R.raw.si_7),
		        Tile(generateRandomColumn(divW), width, height, 1, R.raw.do_1_octave),
		        Tile(generateRandomColumn(divW), width, height, 1, R.raw.do_1),
		        Tile(generateRandomColumn(divW), width, height, 1, R.raw.do_1),
		        Tile(generateRandomColumn(divW), width, height, 1, R.raw.fa_4),
		        Tile(generateRandomColumn(divW), width, height, 1, R.raw.so_5),
		        Tile(generateRandomColumn(divW), width, height, 1, R.raw.fa_4),
		        Tile(generateRandomColumn(divW), width, height, 1, R.raw.mi_3),
		        Tile(generateRandomColumn(divW), width, height, 1, R.raw.re_2),
		        Tile(generateRandomColumn(divW), width, height, 1, R.raw.mi_3),
		        Tile(generateRandomColumn(divW), width, height, 1, R.raw.fa_4),
		        Tile(generateRandomColumn(divW), width, height, 1, R.raw.mi_3),
		        Tile(generateRandomColumn(divW), width, height, 1, R.raw.re_2),
		        Tile(generateRandomColumn(divW), width, height, 1, R.raw.do_1),
		        Tile(generateRandomColumn(divW), width, height, 1, R.raw.re_2),
		        Tile(generateRandomColumn(divW), width, height, 1, R.raw.mi_3),
		        Tile(generateRandomColumn(divW), width, height, 1, R.raw.re_2),
		        Tile(generateRandomColumn(divW), width, height, 1, R.raw.do_1),
		        Tile(generateRandomColumn(divW), width, height, 1, R.raw.re_2),
		        Tile(generateRandomColumn(divW), width, height, 1, R.raw.do_1),
            ))
        }

        private fun generateRandomColumn(upperBound: Int): Int {
            val rand = Random()
            return rand.nextInt(upperBound)
        }

    }
}