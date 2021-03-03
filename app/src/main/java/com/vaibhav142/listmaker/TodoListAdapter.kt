package com.vaibhav142.listmaker

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class TodoListAdapter : RecyclerView.Adapter<TodoListViewHolder>() {

    private var todoLists = mutableListOf("Android Dev", "House Work", "Errands", "Shopping")

    fun addItem(newItem: String) {
        if (newItem == "") {
            return
        }
        todoLists.add(newItem)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.todo_list_view_holder, parent, false)
        return TodoListViewHolder(view)
    }

    override fun onBindViewHolder(holder: TodoListViewHolder, position: Int) {
        holder.listItemNumberValue.text = (position + 1).toString()
        holder.listItemStringValue.text = todoLists[position]
    }

    override fun getItemCount(): Int {
        return todoLists.size
    }
}