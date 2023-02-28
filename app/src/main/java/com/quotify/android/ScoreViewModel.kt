package com.quotify.android

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScoreViewModel(val score: Int) : ViewModel() {

    private val _highScore = MutableLiveData<Int>(score)

    val highScore : LiveData<Int>
    get() = _highScore

    fun updateScore(newScore: Int) {
        _highScore.value = newScore
    }
}