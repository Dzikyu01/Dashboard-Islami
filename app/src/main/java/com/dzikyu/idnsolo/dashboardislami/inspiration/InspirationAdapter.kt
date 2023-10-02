package com.dzikyu.idnsolo.dashboardislami.inspiration

import com.dzikyu.idnsolo.dashboardislami.R

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class InspirationlistAdapter
    (private val listInspiration: ArrayList<InspirationModel>) :
    RecyclerView.Adapter<InspirationlistAdapter.listViewHolder>() {
    inner class listViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imgInspiration : ImageView = itemView.findViewById(R.id.img_inspiration)
    }

    override fun onCreateViewHolder
                (parent: ViewGroup, viewType: Int): listViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_row_inpiration, parent, false)

        return listViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listInspiration.size
    }

    override fun onBindViewHolder(holder: listViewHolder, position: Int) {
        val inspiration = listInspiration[position]

        Glide.with(holder.itemView.context)
            .load(inspiration.inspirationImage)
            .into(holder.imgInspiration)
    }
}