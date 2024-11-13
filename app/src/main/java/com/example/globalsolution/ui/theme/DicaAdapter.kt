package com.example.globalsolution.ui.theme

import android.view.View
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.recyclerview.widget.RecyclerView
import android.widget.TextView
import com.example.globalsolution.R

class DicaAdapter() :
    RecyclerView.Adapter<DicaAdapter.ItemViewHolder>() {

    private var items = listOf<DicaModel>()

    inner class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView = view.findViewById<TextView>(R.id.textViewItem)


        fun bind(item: DicaModel) {
            textView.text = item.name

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    fun updateItems(newItems: List<DicaModel>) {
        items = newItems
        notifyDataSetChanged()
    }
}