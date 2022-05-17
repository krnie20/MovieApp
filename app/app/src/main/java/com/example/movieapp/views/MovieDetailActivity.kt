package com.example.movieapp.views

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.movieapp.R


class MovieDetailActivity : AppCompatActivity() {
    lateinit var tv_title : TextView
    lateinit var tv_desc : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val movieTitle = intent.getStringExtra("title")
        val imageResourceId =  intent.getStringExtra("imgURL")
        val ytURL = intent.getStringExtra("ytURL")

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainer, youtubeFragment())
            commit()
        }

        val bundle = Bundle()
        val fragment = youtubeFragment()
        bundle.putString("videoId", ytURL)
        fragment.arguments = bundle
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainer, fragment)
        transaction.commit()

        setContentView(R.layout.activity_movie_detail)

        tv_title = findViewById(R.id.detail_movie_title)
        tv_desc = findViewById(R.id.detail_movie_desc)

        tv_title.text = movieTitle
        supportActionBar?.title = movieTitle
        Glide.with(this).load(imageResourceId).into(findViewById(R.id.detail_movie_img))
    }

    override fun onStart() {
        super.onStart()
    }
}
