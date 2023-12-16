package com.example.flores_Alvarado_Sepulveda.chistesymaschistes

import android.annotation.SuppressLint
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ImageButton
import android.widget.ListView
import androidx.room.Room
import com.example.flores_Alvarado_Sepulveda.chistesymaschistes.DataBase.DataBase
import com.example.flores_Alvarado_Sepulveda.chistesymaschistes.Entity.Chiste

class Guardados : AppCompatActivity() {

    private lateinit var listaChistes: ListView
    private lateinit var chists: MutableList<Chiste>
    private lateinit var adapter : ArrayAdapter<String>
    private lateinit var baseDatos: DataBase
    private lateinit var mediaPlayer: MediaPlayer
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_chistes)

        mediaPlayer = MediaPlayer.create(this, R.raw.precionar_boton)


        baseDatos = Room.databaseBuilder(
            applicationContext,
            DataBase::class.java, "database"
        ).allowMainThreadQueries().fallbackToDestructiveMigration().build()

        val ProdDao = baseDatos.productoDao()
        //ProdDao.insertAll(nProduct)

        val users: List<Chiste> = ProdDao.getAll()

        listaChistes = findViewById(R.id.ListView)

        chists = users.toMutableList()

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, chists.map { it.chisteText })

        listaChistes.adapter = adapter


        //chists.clear()
        for (chiste: Chiste in users){
            Log.d("PROD", chiste.chisteText!!)
            chists.add(Chiste(chiste.id,chiste.chisteText))
        }
        adapter.notifyDataSetChanged()
        //adapter.notifyDataSetChanged()


        // Configurar el botón de retorno (flecha)
        val btnBack: ImageButton = findViewById(R.id.btnBack)
        btnBack.setOnClickListener {
            mediaPlayer.start()
            // Acciones al presionar la flecha de retorno
            onBackPressed()
        }

    }
}