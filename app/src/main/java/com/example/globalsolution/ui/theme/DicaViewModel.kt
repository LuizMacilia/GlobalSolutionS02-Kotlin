package com.example.globalsolution.ui.theme

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DicasViewModel(application: Application) : AndroidViewModel(application) {

    private val DicaDao: DicaDao
    val DicasLiveData: LiveData<List<DicaModel>>

    init {
        val database = Room.databaseBuilder(
            getApplication(),
            DicaDatabase::class.java,
            "Dicas_database"
        ).build()

        DicaDao = database.DicaDao()
        DicasLiveData = DicaDao.getAll()
    }

    fun addDica(dica: String, desc:String) {
        viewModelScope.launch(Dispatchers.IO) {
            val newDica = DicaModel(name = dica, descricao = desc)
            DicaDao.insert(newDica)
        }
    }


}