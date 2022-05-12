package com.example.movieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class FragmentsTestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragments_test)

        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()
        val startpageYoutubeFragment = Startpage_youtube_fragment()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, startpageYoutubeFragment)
            commit()
        }

        val btnFragment1 = findViewById<Button>(R.id.btnFragment1)
        val btnFragment2 = findViewById<Button>(R.id.btnFragment2)

        btnFragment1.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, firstFragment)
                commit()
            }
        }

        btnFragment2.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, secondFragment)
                commit()
            }
        }
    }
}