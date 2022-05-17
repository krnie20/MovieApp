package com.example.movieapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.MovieItemClickListener
import com.example.movieapp.R
import com.example.movieapp.model.Movie

class MovieAdapter(
    var context: Context,
    var mData: List<Movie>,
    var movieItemClickListener: MovieItemClickListener
) : RecyclerView.Adapter<MovieAdapter.MyViewHolder>() {
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val TvTitle: TextView = itemView.findViewById(R.id.movie_item_title)
        val ImgMovie: ImageView = itemView.findViewById(R.id.movie_item_img)

        init {
            itemView.setOnClickListener {
                movieItemClickListener.onMovieClick(mData[adapterPosition], ImgMovie)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.movie_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.TvTitle.text = mData.get(position).title
        Glide.with(context).load(mData.get(position).thumbnail).into(holder.ImgMovie)
    }

    override fun getItemCount(): Int {
        return mData.size
    }
}