package com.example.movieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val lstSlides: MutableList<Slide> = ArrayList()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Add more slides as necessary
        lstSlides.add(Slide(R.drawable.slide_1, "Avengers"))
        lstSlides.add(Slide(R.drawable.slide_2, "Ironman"))

        val sliderpager: ViewPager = findViewById<ViewPager>(R.id.slider_page)
        sliderpager.adapter = SliderPagerAdapter(this, lstSlides)
    }
}