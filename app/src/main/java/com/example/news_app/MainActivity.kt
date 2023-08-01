package com.example.news_app

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.news_app.FetchDataListener
import com.example.news_app.Models.NewsHeadlines
import com.example.news_app.R
import com.example.news_app.RequestManager
import com.example.news_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
               setContentView(R.layout.activity_main)

        // Make the API call to get top headlines
        val country = "us" // Replace with the desired country code
        val category = "business" // Replace with the desired category, or leave it null for all categories
        val query = "keyword" // Replace with the desired keyword, or leave it null if you don't want to filter by keyword

        val requestManager = RequestManager(this)
        requestManager.getNewsHeadlines(object :
            FetchDataListener<List<NewsHeadlines.NewsHeadlines>> {
            override fun onFetchData(response: List<NewsHeadlines.NewsHeadlines>?, message: String) {
                // Handle the successful response here
                response?.let { articles ->
                    for (article in articles) {
                        val title = article.title
                        val description = article.description
                        // Process the data as needed
                    }
                }
            }

            override fun onError(message: String) {
                // Handle the error response here
                Log.e("NewsApp", "API call failed: $message")
            }
        }, category, query)
    }
}