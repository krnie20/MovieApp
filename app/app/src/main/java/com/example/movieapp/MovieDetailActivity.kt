package com.example.movieapp

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView


class MovieDetailActivity : AppCompatActivity() {
    lateinit var movieThumbnail : ImageView
    // lateinit var movieCover : ImageView
    lateinit var tv_title : TextView
    lateinit var tv_desc : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragments_test)

        val startpageYoutubeFragment = SecondFragment()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainer, startpageYoutubeFragment)
            commit()
        }

        val youtubePlayerView = YouTubePlayerView(this)

        setContentView(R.layout.activity_movie_detail)

        var movieTitle = intent.getStringExtra("title")
        var imageResourceId =  intent.getStringExtra("imgURL")
        var coverResourceId = intent.getStringExtra("imgCover")
        movieThumbnail = findViewById(R.id.detail_movie_img)
        // movieCover = findViewById(R.id.detail_movie_cover)
        tv_title = findViewById(R.id.detail_movie_title)
        tv_desc = findViewById(R.id.detail_movie_desc)

        tv_title.text = movieTitle
        supportActionBar?.title = movieTitle
        Glide.with(this).load(imageResourceId).into(movieThumbnail)
        // Glide.with(this).load(coverResourceId).into(movieCover)
    }
}
