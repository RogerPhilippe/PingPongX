package br.com.fiap.rpp.pingpongx.ui.game

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import br.com.fiap.rpp.pingpongx.R
import kotlinx.android.synthetic.main.activity_game.*

class GameActivity : AppCompatActivity() {

    private lateinit var mGameViewModel: GameViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        mGameViewModel = GameViewModel()

        val players = intent.extras?.get("players") as HashMap<*, *>

        if (players.isNotEmpty() ) {

            playerOneLabelID.text = players["p1"].toString()
            playerTwoLabelID.text = players["p2"].toString()

        }

        mGameViewModel.getCurrentPlayerOneScoreLiveData().observeForever(Observer {})

        mGameViewModel.getCurrentPlayerTwoScoreLiveData().observeForever(Observer {})

    }
}
