package com.example.dicodingsubmission_basic

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class ListCharaAdapter(private var listChara: ArrayList<Characters>): RecyclerView.Adapter<ListCharaAdapter.ListViewHolder>() {
    class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDesc: TextView = itemView.findViewById(R.id.tv_item_description)
        val cardview: CardView = itemView.findViewById(R.id.card_view)
    }

    fun filterList(filterlist: ArrayList<Characters>){
        listChara = filterlist
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_chara, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, desc, photo) = listChara[position]
        holder.tvName.text = name
        holder.tvDesc.text = desc
        holder.imgPhoto.setImageResource(photo)

        holder.cardview.startAnimation(AnimationUtils.loadAnimation(holder.cardview.context, R.anim.scale_up))
        holder.itemView.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context,DetailActivity::class.java)
            intentDetail.putExtra(DetailActivity.EXTRA_CHARACTER, listChara[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetail)
        }
    }

    override fun getItemCount() = listChara.size
}