package com.example.pianotiles

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class MainMenuViewModel : ViewModel() {
    private val mute: MutableLiveData<Boolean> = MutableLiveData<Boolean>(false)
    private val level: MutableLiveData<Int> = MutableLiveData<Int>(1)

    fun init(level: Int, mute: Boolean) {
        this.level.postValue(level)
        this.mute.postValue(mute)
    }
}