package com.example.globalsolution.ui.theme
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DicaModel(
    val name: String,
    val descricao: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0)
