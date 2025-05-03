package com.example.pianotiles

import java.util.Random

class Tiles(column: Int, width: Float, length: Float, note: Int) {
    var x         : Float = 0f
    var y         : Float = 0f
    var width     : Float = 0f
    var height    : Float = 0f
    var note      : Int   = 0
    var isPass    : Boolean = false
    var toBeDelete: Boolean = false
    val rand      : Random = Random();
    var addedScore: Boolean = false
    var column    : Int = 0
    var color     : Int = 0
    var timestamp : Long = 0
    var clicked   : Boolean = false

    init {
        this.note = note
        this.column = column
        this.isPass = false
        when(column) {
            0 -> { this.x = 0 * width / 4; this.y = -length; this.width = width / 4; this.height = length }
            1 -> { this.x = 1 * width / 4; this.y = -length; this.width = width / 4; this.height = length }
            2 -> { this.x = 2 * width / 4; this.y = -length; this.width = width / 4; this.height = length }
            3 -> { this.x = 3 * width / 4; this.y = -length; this.width = width / 4; this.height = length }
        }
    }

    constructor(column: Int, width: Float, length: Float, note: Int, color: Int)
            :this(column, width, length, note) {
        this.color = color
    }

    fun resetTiles() {
        timestamp = System.currentTimeMillis()
        column = rand.nextInt(4)
        addedScore =false
        x = -height
        isPass = false
        toBeDelete = false
    }
}
