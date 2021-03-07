package com.example.myapplication.ui.main

import android.graphics.Color
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class ComponentAdapter : RecyclerView.Adapter<ComponentAdapter.ViewHolder>() {

    var onItemClickListener: ((category: ComponentType) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent).apply {
            itemView.setOnClickListener {
                onItemClickListener?.invoke(ComponentType.values()[adapterPosition])
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(ComponentType.values()[position])
    }

    override fun getItemCount(): Int = ComponentType.values().size

    class ViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        TextView(parent.context).apply {
            setTextColor(Color.BLACK)
            val padding = parent.resources.getDimension(R.dimen.item_text_view_padding).toInt()
            setPadding(padding, padding, padding, padding)
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
        }
    ) {
        fun bind(item: ComponentType) {
            (itemView as TextView).text = item.label
        }
    }
}