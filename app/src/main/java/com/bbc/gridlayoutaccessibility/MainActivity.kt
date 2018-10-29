package com.bbc.gridlayoutaccessibility

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

data class Thing(val name: String)

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val things = listOf(Thing("apple"), Thing("banana"), Thing("cherry"), Thing("dumbfruit"), Thing("elephantfruit"), Thing("fig"), Thing("guava"))
        recyclerView.layoutManager = GridLayoutManager(this, 3, GridLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = GridAdapter(things)
    }
}

class GridAdapter(private val items: List<Thing>) : RecyclerView.Adapter<ThingViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ThingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return ThingViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ThingViewHolder, position: Int) {
        holder.textView.text = items[position].name
    }

}


class ThingViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val textView: TextView = itemView.findViewById(R.id.thing_name)
}
