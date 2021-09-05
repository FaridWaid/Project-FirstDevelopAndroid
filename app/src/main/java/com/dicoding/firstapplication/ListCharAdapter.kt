package com.dicoding.firstapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListCharAdapter(private val listChar: ArrayList<Character>): RecyclerView.Adapter<ListCharAdapter.ListViewHolder>() {
    inner class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvDetail: TextView = itemView.findViewById(R.id.tv_item_detail)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_row_char, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val charAnime = listChar[position]

        Glide.with(holder.itemView.context)
            .load(charAnime.photo)
            .apply(RequestOptions().override(120,120))
            .into(holder.imgPhoto)

        holder.tvName.text = charAnime.name
        holder.tvDetail.text = charAnime.detail
    }

    override fun getItemCount(): Int {
        return listChar.size
    }
}