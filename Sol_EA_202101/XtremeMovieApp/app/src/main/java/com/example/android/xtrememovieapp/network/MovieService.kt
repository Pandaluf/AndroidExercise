package com.example.android.xtrememovieapp.network

import com.example.android.xtrememovieapp.models.ApiResponseDetails
import retrofit2.Call
import retrofit2.http.GET

interface MovieService {
    @GET("3/movie/popular?api_key=3cae426b920b29ed2fb1c0749f258325")
    fun getMovies(): Call<ApiResponseDetails>
}