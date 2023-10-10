package com.dzikyu.idnsolo.dashboardislami.doa.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dzikyu.idnsolo.dashboardislami.R
import com.dzikyu.idnsolo.dashboardislami.doa.DetailDoaActivity
import com.dzikyu.idnsolo.dashboardislami.doa.model.DoaModel

class DoaListAdapter(
    private val listDoa: ArrayList<DoaModel>,
    private val title: String,
    private val logo: Int
) : RecyclerView.Adapter<DoaListAdapter.ListViewHolder>() {
    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgdoa: ImageView = itemView.findViewById(R.id.imgdoa)
        var tvdoa: TextView = itemView.findViewById(R.id.tvdoa)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_row_doa, parent,false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listDoa.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val doa = listDoa[position]

        holder.tvdoa.text = doa.title
        Glide.with(holder.itemView.context)
            .load(logo)
            .into(holder.imgdoa)

        holder.itemView.setOnClickListener{
            val intent = Intent(it.context, DetailDoaActivity::class.java)
            intent.putExtra(DetailDoaActivity.EXTRA_DOA, doa)
            it.context.startActivity(intent)

        }
    }

}