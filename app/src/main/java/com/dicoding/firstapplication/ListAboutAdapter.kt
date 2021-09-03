package com.dicoding.firstapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListAboutAdapter(private val listClub: ArrayList<Club>): RecyclerView.Adapter<ListAboutAdapter.ListViewHolder>() {

    inner class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_about_name)
        var tvEmail: TextView = itemView.findViewById(R.id.tv_about_email)
        var imgPhoto: ImageView = itemView.findViewById(R.id.profile_image)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_about, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val club = listClub[position]

        Glide.with(holder.itemView.context)
            .load(club.photo)
            .apply(RequestOptions().override(120,120))
            .into(holder.imgPhoto)

        holder.tvName.text = club.name
        holder.tvDetail.text = club.detail
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}