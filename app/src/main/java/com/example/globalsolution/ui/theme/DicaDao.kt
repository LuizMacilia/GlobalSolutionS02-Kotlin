package com.example.globalsolution.ui.theme

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DicaDao {

    @Query("SELECT * FROM DicaModel")
    fun getAll(): LiveData<List<DicaModel>>

    @Insert
    fun insert(item: DicaModel)

}