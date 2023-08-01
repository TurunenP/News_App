package com.example.news_app

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.news_app.Models.NewsHeadlines
import com.squareup.picasso.Picasso
import com.example.news_app.databinding.ListItemsBinding

class CustomAdapter(private val context: Context, private var headlines: List<NewsHeadlines.NewsHealines>) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ListItemsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(newsHealines: NewsHeadlines.NewsHealines) {
            binding.textTitle.text = newsHealines.title
            binding.textSource.text = newsHealines.source?.name ?: "Unknown Source"

            newsHealines.urlToImage?.let { imageUrl ->
                Picasso.get().load(imageUrl).into(binding.imgHead)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListItemsBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(headlines[position])
    }

    override fun getItemCount(): Int {
        return headlines.size
    }

    fun updateData(newData: List<NewsHeadlines.NewsHealines>) {
        headlines = newData
        notifyDataSetChanged()
    }
}
