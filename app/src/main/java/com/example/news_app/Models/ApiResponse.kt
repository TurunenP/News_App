package com.example.news_app.Models

class ApiResponse {
    data class ApiResponse(
        val status: String?,
        val totalResults: Int,
        val articles: List<NewsHeadlines>
    )

}




