package br.com.fiap.rpp.pingpongx.ui.slpah

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import br.com.fiap.rpp.pingpongx.R
import br.com.fiap.rpp.pingpongx.ui.start.StartActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            startActivity(Intent(this, StartActivity::class.java))
            finish()
        },2000)
    }



}
