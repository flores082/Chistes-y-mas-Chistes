package com.example.flores_Alvarado_Sepulveda.chistesymaschistes.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.flores_Alvarado_Sepulveda.chistesymaschistes.R

data class mostrado(
    val id: Long = 0,
    val c :String
)
class Lista_Adapter(private val LC: MutableList<mostrado>):
        RecyclerView.Adapter<Lista_Adapter.ProductoViewHolder>(){

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoViewHolder {
            val View = LayoutInflater.from(parent.context).inflate(R.layout.activity_chiste_mostrado, parent, false)
            return ProductoViewHolder(View)

        }
        override fun onBindViewHolder(holder: ProductoViewHolder, position: Int) {
            val item = LC[position]
            holder.bin(item,position + 1) // Agregar 1 para mostrar el número único
        }
        override fun getItemCount(): Int {
            return LC.size
        }

        inner class ProductoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

            private val textView: TextView = itemView.findViewById(R.id.textView)

            fun bin(producto: mostrado, numeroUnico: Int){
                val textoMostrado = "${producto.c} - $numeroUnico"
                textView.text = textoMostrado
            }
        }

    }