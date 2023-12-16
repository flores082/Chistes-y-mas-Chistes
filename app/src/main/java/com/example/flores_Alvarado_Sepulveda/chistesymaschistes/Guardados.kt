package com.example.flores_Alvarado_Sepulveda.chistesymaschistes

import Guardados_Adapter
import android.annotation.SuppressLint
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Debug
import android.util.Log
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageButton
import android.widget.ListView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room

import com.example.flores_Alvarado_Sepulveda.chistesymaschistes.Adapter.Lista_Adapter
import com.example.flores_Alvarado_Sepulveda.chistesymaschistes.Adapter.mostrado
import com.example.flores_Alvarado_Sepulveda.chistesymaschistes.DataBase.DataBase
import com.example.flores_Alvarado_Sepulveda.chistesymaschistes.Entity.Chiste
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class Guardados : AppCompatActivity() {

    private lateinit var listaChistes: ListView
    //private lateinit var listaChistes: RecyclerView
    private lateinit var chists: MutableList<Chiste>
    private lateinit var adapter : ArrayAdapter<String>
    //private lateinit var adapter : Guardados_Adapter
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
        //listaChistes = findViewById(R.id.Recycler)

        chists = users.toMutableList()

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, chists.map { it.chisteText })
        //adapter = Guardados_Adapter(chists,this)

        listaChistes.adapter = adapter


        listaChistes.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            var selectedItem = parent.getItemAtPosition(position) as String

            // Aquí accedes al elemento seleccionado y puedes realizar acciones con él
            //Toast.makeText(this, "Elemento seleccionado: ${selectedItem.name}", Toast.LENGTH_SHORT).show()
            editProducto(selectedItem)
        }

        //chists.clear()
        /*for (chiste: Chiste in users){
            Log.d("PROD", chiste.chisteText!!)
            chists.add(Chiste(chiste.id,chiste.chisteText))
            //adapter.notifyItemInserted(chists.size - 1)
            /*GlobalScope.launch(Dispatchers.IO) {
                Chiste(chiste.id,chiste.chisteText)
            }*/
        }
        adapter.notifyDataSetChanged()*/
        //adapter.notifyDataSetChanged()
        /*fun lista_agregada(chiste:String){
            val nombreEntity = Chiste(ProdDao.getAll().size.toLong()+1,chisteText = chiste)
            chists.add(nombreEntity)
            adapter.notifyItemInserted(chists.size - 1)

            GlobalScope.launch(Dispatchers.IO) {
                nombreEntity
            }
        }*/


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
        //builder.setMessage("Producto seleccionado:")

        builder.setPositiveButton("Eliminar Chiste") { dialog, _ ->
            val ProdDao = baseDatos.productoDao()
            ProdDao.delete(ProdDao.findByName(itemSeleccionado))
            Log.i("AAAAA","ELIMINADO")
            val users: List<Chiste> = ProdDao.getAll()

            //chists.clear()
            adapter.clear()
            adapter.addAll(users.toMutableList().map { it.chisteText })
            /*for (chiste: Chiste in users) {
                Log.d("PROD", chiste.chisteText!!)
                chists.add(chiste)
            }*/

            //adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, chists.map { it.chisteText })
            adapter.notifyDataSetChanged()
            //val users: List<Chiste> = ProdDao.getAll()


            dialog.dismiss()
        }

        builder.setNegativeButton("Cancelar") { dialog, _ ->
            //val ProdDao = baseDatos.productoDao()
            //ProdDao.actualizarPrecio(itemSeleccionado.name!!,itemSeleccionado.cantidad.minus(1))
            //itemSeleccionado.cantidad.plus(1)
            /*for(pr : Product in products){
                if(pr.name==itemSeleccionado.name){
                    pr.cantidad.minus(1)
                }
            }
            val users: List<Producto> = ProdDao.getAll()
            products.clear()
            for (prod: Producto in users){
                Log.d("PROD", prod.nombre.toString())
                products.add(Product(prod.nombre, prod.precio!!))
            }
            adapter.notifyDataSetChanged()*/
            dialog.dismiss()
            // Puedes realizar acciones adicionales al hacer clic en Cancelar
        }
        /*builder.setNeutralButton("Eliminar producto") { dialog, _ ->

            val ProdDao = db.productoDao()
            ProdDao.delete(ProdDao.findByName(itemSeleccionado.name!!,itemSeleccionado.cantidad))
            products.remove(itemSeleccionado)
            adapter.notifyDataSetChanged()
            dialog.dismiss()
        }*/


        val dialog = builder.create()
        dialog.show()
    }
}