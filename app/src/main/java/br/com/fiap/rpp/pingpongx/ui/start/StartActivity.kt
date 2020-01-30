package br.com.fiap.rpp.pingpongx.ui.start

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import br.com.fiap.rpp.pingpongx.R
import br.com.fiap.rpp.pingpongx.ui.game.GameActivity
import kotlinx.android.synthetic.main.activity_start.*

class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        startStartBtn.setOnClickListener {

            if (validEdit(playerOneEditID) && validEdit(playerTwoEditID)) {

                val intent = Intent(this, GameActivity::class.java)

                var players = HashMap<String, String>()
                players["p1"] = playerOneEditID.text.toString()
                players["p2"] = playerTwoEditID.text.toString()
                intent.putExtra("players", players)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show()
            }

        }

    }

    private fun validEdit(editText: EditText): Boolean {
        return editText.text.toString().isNotBlank() && editText.text.toString().isNotEmpty()
    }

}
