package com.example.flores_Alvarado_Sepulveda.chistesymaschistes

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer

class Bienvenida : AppCompatActivity() {
    private lateinit var mediaPlayer:MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {

        mediaPlayer =MediaPlayer.create(this, R.raw.risa)
        mediaPlayer.start()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bienvenida)
        VerBienvenida()
    }

    fun VerBienvenida() {
        object : CountDownTimer(2000, 1000) {
            override fun onTick(p0: Long) {

            }

            override fun onFinish() {
                mediaPlayer.reset()
                val intent = Intent(this@Bienvenida, MainActivity::class.java)
                startActivity(intent)
                finishAffinity()
            }

        }.start()
    }
}