package com.example.globalsolution

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.globalsolution.ui.theme.DicaAdapter
import com.example.globalsolution.ui.theme.DicaViewModelFactory
import com.example.globalsolution.ui.theme.DicasViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: DicasViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Lista de Compras"

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val dicaAdapter = DicaAdapter()
        recyclerView.adapter = dicaAdapter

        val button = findViewById<Button>(R.id.button)
        val editText = findViewById<EditText>(R.id.editText)
        val editTextDesc = findViewById<EditText>(R.id.editTextdesc)

        button.setOnClickListener {
            if (editText.text.isEmpty()) {
                editText.error = "Preencha um valor"
                return@setOnClickListener
            }

            viewModel.addDica(editText.text.toString(), editTextDesc.text.toString())
            editText.text.clear()
        }

        val viewModelFactory = DicaViewModelFactory(application)
        viewModel = ViewModelProvider(this, viewModelFactory).get(DicasViewModel::class.java)

        viewModel.DicasLiveData.observe(this) { items ->
            dicaAdapter.updateItems(items)
        }
    }
}