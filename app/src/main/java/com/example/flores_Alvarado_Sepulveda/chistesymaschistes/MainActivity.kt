package com.example.flores_Alvarado_Sepulveda.chistesymaschistes

import android.annotation.SuppressLint
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toolbar
import androidx.room.Room
import com.example.flores_Alvarado_Sepulveda.chistesymaschistes.About.Presentacion
import com.example.flores_Alvarado_Sepulveda.chistesymaschistes.DataBase.DataBase
import com.example.flores_Alvarado_Sepulveda.chistesymaschistes.Entity.Chiste
import com.example.flores_Alvarado_Sepulveda.chistesymaschistes.Listas.Lista_chistes
import com.example.flores_Alvarado_Sepulveda.chistesymaschistes.Listas.Llamar_chistes

class MainActivity : AppCompatActivity() {
    private lateinit var mediaPlayer: MediaPlayer
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mediaPlayer =MediaPlayer.create(this, R.raw.precionar_boton)

        // Configurar el Toolbar
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.myToolbar)
        setSupportActionBar(toolbar)

        // Configurar el botón de retorno (flecha)
        val btnBack: ImageButton = findViewById(R.id.btnBack)
        val presintacion: Button = findViewById(R.id.button1)
        val generados: Button = findViewById(R.id.button2)
        val guardados: Button = findViewById(R.id.button3)

        btnBack.setOnClickListener {
            mediaPlayer.start()
            // Acciones al presionar la flecha de retorno
            finishAffinity()
        }

        presintacion.setOnClickListener{
            mediaPlayer.start()
            val intent1 =Intent(this, Presentacion::class.java)
            startActivity(intent1)
        }
        generados.setOnClickListener{
            mediaPlayer.start()
            val intent2 =Intent(this, Llamar_chistes::class.java)
            startActivity(intent2)

            //adapter.notifyDataSetChanged()
        }
        guardados.setOnClickListener{
            mediaPlayer.start()
            val intent3 =Intent(this, Guardados::class.java)
            startActivity(intent3)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_inicio, menu)
        return true
    }
    /*PARA AÑADIR UN CHISTE
            var baseDatos = Room.databaseBuilder(
                applicationContext,
                DataBase::class.java, "database"
            ).allowMainThreadQueries().build()
            val CHISTE = ""
            val ProdDao = baseDatos.productoDao()
            val produ = Chiste(ProdDao.getAll().size.toLong()+1,Chiste)
            ProdDao.insertAll(produ)*/



}