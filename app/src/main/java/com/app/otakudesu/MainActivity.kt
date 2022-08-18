package com.app.otakudesu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.RelativeLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.otakudesu.data.AnimeResponse
import com.app.otakudesu.data.OnGoingItem
import com.app.otakudesu.databinding.ActivityMainBinding
import com.app.otakudesu.network.AnimeApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private var animeAdapter = AnimeAdapter()
    private var _binding : ActivityMainBinding? = null
    private val binding get() = _binding as ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getAnimeDataApi()
    }

    private fun getAnimeDataApi() {
        AnimeApiConfig.getApiService().getAnimeList().enqueue(object : Callback<AnimeResponse>{
            override fun onResponse(
                call: Call<AnimeResponse>,
                response: Response<AnimeResponse>
            ) {
                response.body()?.let {
                    setData(it.home?.onGoing as List<OnGoingItem>)
                }
            }

            override fun onFailure(call: Call<AnimeResponse>, t: Throwable) {
                Log.e("TAG", "onFailure: $t")
            }
        })
    }

    private fun setData(data: List<OnGoingItem>) {
        binding.rvAnime.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = animeAdapter
            animeAdapter.setData(data)
        }
    }
}