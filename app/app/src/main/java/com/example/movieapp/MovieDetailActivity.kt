package com.example.movieapp

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide


class MovieDetailActivity : AppCompatActivity() {
    lateinit var movieThumbnail : ImageView
    lateinit var movieCover : ImageView
    lateinit var tv_title : TextView
    lateinit var tv_desc : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        var movieTitle = intent.getStringExtra("title")
        var imageResourceId =  intent.getIntExtra("imgURL", 0)
        var coverResourceId = intent.getIntExtra("imgCover", 0)
        movieThumbnail = findViewById(R.id.detail_movie_img)
        movieCover = findViewById(R.id.detail_movie_cover)
        tv_title = findViewById(R.id.detail_movie_title)
        tv_desc = findViewById(R.id.detail_movie_desc)

        tv_title.text = movieTitle
        supportActionBar?.setTitle(movieTitle)
        Glide.with(this).load(coverResourceId).into(movieCover)
        Glide.with(this).load(imageResourceId).into(movieThumbnail)
    }
}
