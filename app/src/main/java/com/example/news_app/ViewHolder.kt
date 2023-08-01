package com.example.news_app
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val text_title: TextView = itemView.findViewById(R.id.text_title)
    val text_source: TextView = itemView.findViewById(R.id.text_source)
    val img_headline: ImageView = itemView.findViewById(R.id.imgHead)
    val cardView: CardView = itemView.findViewById(R.id.main_container)
}
