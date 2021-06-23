package com.dicoding.core.api

import com.dicoding.core.response.ListSportResponse
import retrofit2.http.GET

interface ApiService {
    @GET("all_sports.php")
    suspend fun getList(): ListSportResponse
}