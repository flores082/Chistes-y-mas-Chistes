package com.example.flores_Alvarado_Sepulveda.chistesymaschistes.Adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.flores_Alvarado_Sepulveda.chistesymaschistes.R

class text_chiste(view: View): RecyclerView.ViewHolder(view) {

    val chiste = view.findViewById<TextView>(R.id.textView4)

    fun render(Compras_lista2Model: mostrado){
        chiste.text = Compras_lista2Model.c

    }
}