package com.example.flores_Alvarado_Sepulveda.chistesymaschistes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.room.Room
import com.example.flores_Alvarado_Sepulveda.chistesymaschistes.DataBase.DataBase
import com.example.flores_Alvarado_Sepulveda.chistesymaschistes.Entity.Chiste

class Guardados : AppCompatActivity() {

    private lateinit var listaChistes: ListView
    private lateinit var chists: MutableList<Chiste>
    private lateinit var adapter : ArrayAdapter<String>
    private lateinit var baseDatos: DataBase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guardados)

        listaChistes = findViewById(R.id.ListView)

        chists = mutableListOf(
            Chiste(1,"jajajaja")
        )

        adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, chists.map { it.chisteText })

        listaChistes.adapter = adapter

        baseDatos = Room.databaseBuilder(
            applicationContext,
            DataBase::class.java, "database"
        ).allowMainThreadQueries().build()

        val ProdDao = baseDatos.productoDao()
        //ProdDao.insertAll(nProduct)

        val users: List<Chiste> = ProdDao.getAll()
        for (chiste: Chiste in chists){
            Log.d("PROD", chiste.chisteText!!)
        }
        adapter.notifyDataSetChanged()

    }
}