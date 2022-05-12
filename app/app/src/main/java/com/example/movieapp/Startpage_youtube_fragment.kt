package com.example.movieapp

import android.os.Bundle
import android.content.Context
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.movieapp.adapter.SliderPagerAdapter
import com.example.movieapp.databinding.FragmentStartpageYoutubeBinding
import com.example.movieapp.item.Slide
import com.google.android.material.tabs.TabLayout

class Startpage_youtube_fragment : Fragment(R.layout.fragment_startpage_youtube) {
    /*lateinit var binding: FragmentStartpageYoutubeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  FragmentStartpageYoutubeBinding.inflate(layoutInflater)

        val lstSlides: MutableList<Slide> = ArrayList()
        val sliderpager: ViewPager = binding.sliderPage1 //this.findViewById<ViewPager>(R.id.slider_page)
        val indicator: TabLayout = binding.indicator1 // this.findViewById(R.id.indicator)
        sliderpager.adapter = SliderPagerAdapter(this, lstSlides)
        indicator.setupWithViewPager(sliderpager, true)
    }*/
}