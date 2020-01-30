package br.com.fiap.rpp.pingpongx.ui.game

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {

    private val currentPlayerOneScoreLiveData = MutableLiveData<Int>()
    private val currentPlayerTwoScoreLiveData = MutableLiveData<Int>()

    fun getCurrentPlayerOneScoreLiveData() = currentPlayerOneScoreLiveData

    fun getCurrentPlayerTwoScoreLiveData() = currentPlayerTwoScoreLiveData

}
