package com.example.movieapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.movieapp.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        val lstSlides: MutableList<Slide> = ArrayList()

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val indicator: TabLayout = binding.indicator // this.findViewById(R.id.indicator)
        // Add more slides as necessary ---------------------------
        lstSlides.add(Slide(R.drawable.slide_1, "Avengers"))
        lstSlides.add(Slide(R.drawable.slide_2, "Ironman"))

        //---------------------------------------------------------

        val sliderpager: ViewPager = binding.sliderPage //this.findViewById<ViewPager>(R.id.slider_page)
        sliderpager.adapter = SliderPagerAdapter(this, lstSlides)
        indicator.setupWithViewPager(sliderpager, true)

        // Setting the viewbinding
        val view = binding.root
        setContentView(view)
    }
}

