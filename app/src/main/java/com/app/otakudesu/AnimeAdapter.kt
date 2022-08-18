package com.app.otakudesu

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.otakudesu.data.OnGoingItem
import com.app.otakudesu.databinding.RowAnimeItemBinding
import com.bumptech.glide.Glide

class AnimeAdapter : RecyclerView.Adapter<AnimeAdapter.AnimeViewHolder>() {

    private val listAnime = arrayListOf<OnGoingItem>()

    inner class AnimeViewHolder(val itemAnimeBinding: RowAnimeItemBinding) :
        RecyclerView.ViewHolder(itemAnimeBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = AnimeViewHolder(
        RowAnimeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        holder.itemAnimeBinding.apply {
            with(listAnime[position]) {
                tvTitle.text = title
                tvEps.text = episode
                Glide.with(imgThumb.context).load(thumb).into(imgThumb)
            }
        }
    }

    override fun getItemCount() = listAnime.size

    fun setData(anime: List<OnGoingItem>) {
        this.listAnime.clear()
        this.listAnime.addAll(anime)
    }
}