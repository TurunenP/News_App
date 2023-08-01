// RequestManager.kt
package com.example.news_app

import android.content.Context
import android.widget.Toast
import com.example.news_app.Models.ApiResponse
import com.example.news_app.Models.NewsHeadlines
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

class RequestManager(private val context: Context) {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://newsapi.org/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getNewsHeadlines(listener: FetchDataListener<List<NewsHeadlines>>,
                         category: String, query: String) {
        val callNewsApi = retrofit.create(CallNewsApi::class.java)
        val call = callNewsApi.callHeadlines("us", category, query, context.getString(R.string.api_key))

        try {
            call.enqueue(object : Callback<ApiResponse.ApiResponse> {
                override fun onResponse(call: Call<ApiResponse.ApiResponse>, response: Response<ApiResponse.ApiResponse>) {
                    if (response.isSuccessful) {
                        listener.onFetchData(response.body()?.articles, response.message())
                    } else {
                        Toast.makeText(context, "Error!!", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<ApiResponse.ApiResponse>, t: Throwable) {
                    listener.onError("Request Failure")
                }
            })
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    // News interface
    interface CallNewsApi {
        @GET("top-headlines")
        fun callHeadlines(
            @Query("country") country: String,
            @Query("category") category: String,
            @Query("q") query: String,
            @Query("apiKey") api_key: String
        ): Call<ApiResponse.ApiResponse>
    }
}
