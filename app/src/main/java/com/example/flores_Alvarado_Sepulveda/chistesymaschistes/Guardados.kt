package com.example.flores_Alvarado_Sepulveda.chistesymaschistes

import android.annotation.SuppressLint
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageButton
import android.widget.ListView
import androidx.appcompat.app.AlertDialog
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

        val users: List<Chiste> = ProdDao.getAll()

        listaChistes = findViewById(R.id.ListView)

        chists = users.toMutableList()

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, chists.map { it.chisteText })

        listaChistes.adapter = adapter


        listaChistes.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            var selectedItem = parent.getItemAtPosition(position) as String

            // Aquí accedes al elemento seleccionado y puedes realizar acciones con él
            editProducto(selectedItem)
        }


        // Configurar el botón de retorno (flecha)
        val btnBack: ImageButton = findViewById(R.id.btnBack)
        btnBack.setOnClickListener {
            mediaPlayer.start()
            // Acciones al presionar la flecha de retorno
            onBackPressed()
        }

    }
    fun editProducto(itemSeleccionado: String) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Eliminar Chiste?")

        builder.setPositiveButton("Eliminar Chiste") { dialog, _ ->
            val ProdDao = baseDatos.productoDao()
            ProdDao.delete(ProdDao.findByName(itemSeleccionado))
            Log.i("AAAAA", "ELIMINADO")
            val users: List<Chiste> = ProdDao.getAll()

            //chists.clear()
            adapter.clear()
            adapter.addAll(users.toMutableList().map { it.chisteText })
            adapter.notifyDataSetChanged()

            dialog.dismiss()
        }

        builder.setNegativeButton("Cancelar") { dialog, _ ->

            dialog.dismiss()
            // Puedes realizar acciones adicionales al hacer clic en Cancelar
        }


        val dialog = builder.create()
        dialog.show()
    }
}