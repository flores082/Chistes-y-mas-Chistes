package com.example.flores_Alvarado_Sepulveda.chistesymaschistes.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class Chiste (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id : Long,
    @ColumnInfo(name = "chisteText") val chisteText: String?
 ): Serializable {


    fun elChiste(): String {
        return chisteText ?: "" // Devuelve el texto del chiste o una cadena vacía si es nulo
    }
}