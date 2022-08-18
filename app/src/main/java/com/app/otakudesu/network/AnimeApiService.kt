package com.app.otakudesu.network

import com.app.otakudesu.data.AnimeResponse
import com.app.otakudesu.data.OnGoingItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("home")
    fun getAnimeList(): Call<AnimeResponse>
}