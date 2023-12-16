package com.example.flores_Alvarado_Sepulveda.chistesymaschistes.DataBase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.flores_Alvarado_Sepulveda.chistesymaschistes.Entity.Chiste

@Database(entities = [Chiste::class], version = 1)
abstract class DataBase : RoomDatabase() {
    abstract fun productoDao(): JokeDao
}
