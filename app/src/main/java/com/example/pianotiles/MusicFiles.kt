package com.example.pianotiles

import java.util.Random

class MusicFiles(width: Int, height: Int) {
    var width: Int = 0
    var height: Int = 0
    var littleStar: ArrayList<Tiles> = ArrayList<Tiles>()
    var minuet: ArrayList<Tiles> = ArrayList<Tiles>()
    var kartini: ArrayList<Tiles> = ArrayList<Tiles>()

    init {
        this.width = width
        this.height = height
        addLittleStar()
        addMinuet()
        addKartini()
    }

    private fun addKartini() {
        kartini.add(Tiles(generateRandomColumn(), width.toFloat(), (2 * height / 4).toFloat(), 1))
        kartini.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 2))
        kartini.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 3))
        kartini.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 4))
        kartini.add(Tiles(generateRandomColumn(), width.toFloat(), (2 * height / 4).toFloat(), 5))
        kartini.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 3))
        kartini.add(Tiles(generateRandomColumn(), width.toFloat(), (2 * height / 4).toFloat(), 1))
        kartini.add(Tiles(generateRandomColumn(), width.toFloat(), (2 * height / 4).toFloat(), 6))
        kartini.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 8))
        kartini.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 7))
        kartini.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 6))
        kartini.add(Tiles(generateRandomColumn(), width.toFloat(), (4 * height / 4).toFloat(), 5, R.color.green))
        kartini.add(Tiles(generateRandomColumn(), width.toFloat(), (2 * height / 4).toFloat(), 4))
        kartini.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 6))
        kartini.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 5))
        kartini.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 4))
        kartini.add(Tiles(generateRandomColumn(), width.toFloat(), (2 * height / 4).toFloat(), 3))
        kartini.add(Tiles(generateRandomColumn(), width.toFloat(), (2 * height / 4).toFloat(), 1))
        kartini.add(Tiles(generateRandomColumn(), width.toFloat(), (2 * height / 4).toFloat(), 2))
        kartini.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 4))
        kartini.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 3))
        kartini.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 2))
        kartini.add(Tiles(generateRandomColumn(), width.toFloat(), (4 * height / 4).toFloat(), 1))
        kartini.add(Tiles(generateRandomColumn(), width.toFloat(), (2 * height / 4).toFloat(), 4))
        kartini.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 3))
        kartini.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 4))
        kartini.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 6))
        kartini.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 5))
        kartini.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 6))
        kartini.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 5))
        kartini.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 3))
        kartini.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 1))
        kartini.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 3))
        kartini.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 2))
        kartini.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 3))
        kartini.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 4))
        kartini.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 6))
        kartini.add(Tiles(generateRandomColumn(), width.toFloat(), (4 * height / 4).toFloat(), 5))
        kartini.add(Tiles(generateRandomColumn(), width.toFloat(), (2 * height / 4).toFloat(), 4))
        kartini.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 3))
        kartini.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 4))
        kartini.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 6))
        kartini.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 5))
        kartini.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 6))
        kartini.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 5))
        kartini.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 3))
        kartini.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 1))
        kartini.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 3))
        kartini.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 2))
        kartini.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 4))
        kartini.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 3))
        kartini.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 2))
        kartini.add(Tiles(generateRandomColumn(), width.toFloat(), (4 * height / 4).toFloat(),1,R.color.yellow))
    }

    private fun addMinuet() {
        minuet.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 5))
        minuet.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 1))
        minuet.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 2))
        minuet.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 3))
        minuet.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 4))
        minuet.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 5))
        minuet.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 1, R.color.green))
        minuet.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 1, R.color.yellow))
        minuet.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 6))
        minuet.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 4))
        minuet.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 5))
        minuet.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 6))
        minuet.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 7))
        minuet.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 8))
        minuet.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 1, R.color.yellow))
        minuet.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 1, R.color.green))
        minuet.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 4))
        minuet.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 5))
        minuet.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 4))
        minuet.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 3))
        minuet.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 2))
        minuet.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 3, R.color.green))
        minuet.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 4))
        minuet.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 3))
        minuet.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 2))
        minuet.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 1))
        minuet.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 2, R.color.yellow))
        minuet.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 3))
        minuet.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 2))
        minuet.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 1))
        minuet.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 2))
        minuet.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 1, R.color.green))
    }

    private fun addLittleStar() {
        littleStar.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 1))
        littleStar.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 1))
        littleStar.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 5))
        littleStar.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 5))
        littleStar.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 6))
        littleStar.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 6))
        littleStar.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 5, R.color.yellow))
        littleStar.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 4))
        littleStar.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 4))
        littleStar.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 3))
        littleStar.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 3))
        littleStar.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 2))
        littleStar.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 2))
        littleStar.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 1, R.color.yellow))
        littleStar.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 5))
        littleStar.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 5))
        littleStar.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 4))
        littleStar.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 4))
        littleStar.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 3))
        littleStar.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 3))
        littleStar.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 2, R.color.yellow))
        littleStar.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 5))
        littleStar.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 5))
        littleStar.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 4))
        littleStar.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 4))
        littleStar.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 3))
        littleStar.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 3))
        littleStar.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 2, R.color.green))
        littleStar.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 1))
        littleStar.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 1))
        littleStar.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 5))
        littleStar.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 5))
        littleStar.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 6))
        littleStar.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 6))
        littleStar.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 5))
        littleStar.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 4))
        littleStar.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 4))
        littleStar.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 3))
        littleStar.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 3))
        littleStar.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 2))
        littleStar.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 2))
        littleStar.add(Tiles(generateRandomColumn(), width.toFloat(), (height / 4).toFloat(), 1, R.color.green))
    }

    fun generateRandomColumn(): Int {
        val rand = Random()
        return rand.nextInt(4)
    }

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
    }
}