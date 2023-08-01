package com.example.news_app

import com.example.news_app.Models.NewsHeadlines

interface FetchDataListener<T> {
    fun onFetchData(response: List<NewsHeadlines.NewsHealines>?, message: String)
    fun onError(message: String)
}

