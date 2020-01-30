package br.com.fiap.rpp.pingpongx.ui.game

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import br.com.fiap.rpp.pingpongx.R
import kotlinx.android.synthetic.main.activity_game.*

class GameActivity : AppCompatActivity() {

    private lateinit var mGameViewModel: GameViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        //mGameViewModel = GameViewModel()
        //mGameViewModel = ViewModelProviders.of(this).get(GameViewModel::class.java)
        mGameViewModel = ViewModelProvider(this).get(GameViewModel::class.java)

        val players = intent.extras?.get("players") as HashMap<*, *>

        if (players.isNotEmpty()) {

            playerOneLabelID.text = players["p1"].toString()
            playerTwoLabelID.text = players["p2"].toString()

        }

        // Initial
        if (mGameViewModel.getCurrentPlayerOneScoreLiveData().value != null) {
            playerOneScoreID.text = mGameViewModel.getCurrentPlayerOneScoreLiveData().value.toString()
        }
        if (mGameViewModel.getCurrentPlayerTwoScoreLiveData().value != null) {
            playerTwoScoreID.text = mGameViewModel.getCurrentPlayerTwoScoreLiveData().value.toString()
        }


        mGameViewModel.getCurrentPlayerOneScoreLiveData().observeForever {
            it as Int
            playerOneScoreID.text = it.toString()
        }

        mGameViewModel.getCurrentPlayerTwoScoreLiveData().observeForever {
            it as Int
            playerTwoScoreID.text = it.toString()
        }

        playerOneSumOneID.setOnClickListener {

            var currentScore = playerOneScoreID.text.toString().toInt()
            mGameViewModel.getCurrentPlayerOneScoreLiveData().value = ++currentScore
        }

        playerTwoSumOneID.setOnClickListener {

            var currentScore = playerTwoScoreID.text.toString().toInt()
            mGameViewModel.getCurrentPlayerTwoScoreLiveData().value = ++currentScore

        }

    }
}
