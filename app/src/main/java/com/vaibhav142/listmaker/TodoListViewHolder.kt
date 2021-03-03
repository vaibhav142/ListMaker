package com.vaibhav142.listmaker

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TodoListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var listItemNumberValue = itemView.findViewById<TextView>(R.id.listItemNumber)
    var listItemStringValue = itemView.findViewById<TextView>(R.id.listItemTextView)
}