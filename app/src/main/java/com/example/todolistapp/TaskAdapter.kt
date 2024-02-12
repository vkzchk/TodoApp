package com.example.todolistapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TaskAdapter(var items:List<Task> = emptyList()): RecyclerView.Adapter<TaskViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val listItemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item_layout, parent, false)
        return TaskViewHolder(listItemView)
    }
    fun updateItems(itemsToUpdate:List<Task>){
        items = itemsToUpdate
        notifyDataSetChanged()
    }
    override fun getItemCount(): Int = items.size
    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.name.text = items[position].title
        holder.position.text = items[position].description
    }
}
class TaskViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
    val name: TextView = itemView.findViewById(R.id.title)
    val position: TextView = itemView.findViewById(R.id.description)
}