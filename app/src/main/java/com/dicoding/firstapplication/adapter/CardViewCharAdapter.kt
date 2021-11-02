package com.dicoding.firstapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.firstapplication.data.Character
import com.dicoding.firstapplication.R

class CardViewCharAdapter(private val listChar: ArrayList<Character>): RecyclerView.Adapter<CardViewCharAdapter.CardViewViewHolder>() {

    inner class CardViewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvRate: TextView = itemView.findViewById(R.id.tv_rate_char)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_cardview_char, parent, false)
        return CardViewViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewViewHolder, position: Int) {
        val charAnime = listChar[position]

        Glide.with(holder.itemView.context)
            .load(charAnime.photo)
            .apply(RequestOptions().override(160,200))
            .into(holder.imgPhoto)

        holder.tvName.text = charAnime.name
        holder.tvRate.text = charAnime.rate

        holder.itemView.setOnClickListener { Toast.makeText(holder.itemView.context, listChar[holder.adapterPosition].name + " have rate: " + listChar[holder.adapterPosition].rate, Toast.LENGTH_SHORT).show() }

    }

    override fun getItemCount(): Int {
        return listChar.size
    }
}