package com.example.flores_Alvarado_Sepulveda.chistesymaschistes.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serial
import java.io.Serializable

@Entity(tableName = "nombres_table")
data class ValoresEnty (
   @PrimaryKey(autoGenerate = true)
   val id : Long = 0,
   val texto: String
 ):Serializable