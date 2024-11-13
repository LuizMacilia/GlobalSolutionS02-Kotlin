package com.example.globalsolution.ui.theme


import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [DicaModel::class], version = 1)
abstract class DicaDatabase : RoomDatabase() {

    abstract fun DicaDao(): DicaDao
}
