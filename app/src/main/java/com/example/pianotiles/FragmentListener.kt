package com.example.pianotiles

interface FragmentListener {
    fun changePage(page: Int)
    fun changeVolume(vol: Int)
    fun changeBackground(id: Int)
    fun setDefault()
    fun setLevel(level: Int)
    fun setScore(score: Int, level: Int)
    fun setGamePlayToLoseState()
    fun setPause(pause: Boolean)
    fun resume()
    fun getVolume(): Int
    fun muteSoundPool(): Boolean
}
