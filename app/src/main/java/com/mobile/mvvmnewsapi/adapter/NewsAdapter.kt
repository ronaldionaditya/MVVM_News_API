package com.mobile.mvvmnewsapi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mobile.mvvmnewsapi.R
import com.mobile.mvvmnewsapi.model.ArticlesItem
import kotlinx.android.synthetic.main.item_news.view.*

class NewsAdapter(var data: List<ArticlesItem?>?): RecyclerView.Adapter<NewsAdapter.NewsHolder>() {
    class NewsHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val img = itemView.itemImg
        val textName = itemView.itemNamaLokasi
        val itemNamaTempat = itemView.itemNamaTempat
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news,parent,false)

        val holder = NewsHolder(view)

        return holder
    }

    override fun onBindViewHolder(holder: NewsHolder, position: Int) {
        holder.itemNamaTempat.text = data?.get(position)?.publishedAt
        holder.textName.text = data?.get(position)?.author

        //load gambar
        Glide.with(holder.itemView.context)
            .load(data?.get(position)?.urlToImage)
            .placeholder(R.drawable.ic_launcher_background)
            .into(holder.img)
    }

    override fun getItemCount(): Int {
        return data?.size ?:0
    }


}