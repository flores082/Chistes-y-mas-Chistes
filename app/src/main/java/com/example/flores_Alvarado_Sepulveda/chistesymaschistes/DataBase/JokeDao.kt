package com.example.flores_Alvarado_Sepulveda.chistesymaschistes.DataBase

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.flores_Alvarado_Sepulveda.chistesymaschistes.Entity.Chiste

@Dao
interface JokeDao {
    @Query("SELECT * FROM chiste")
    fun getAll(): List<Chiste>


    @Query("SELECT * FROM chiste WHERE id IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<Chiste>


    @Query("SELECT * FROM chiste WHERE chisteText LIKE :first " +
            " LIMIT 1")
    fun findByName(first: String): Chiste

    @Insert
    fun insertAll(vararg productos: Chiste)

    @Delete
    fun delete(user: Chiste)

    /*@Query("UPDATE chiste SET Precio = :nuevoPrecio WHERE Nombre = :productoNombre")
    fun actualizarPrecio(productoNombre: String, nuevoPrecio: Int)*/
}