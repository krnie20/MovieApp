package com.example.movieapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.movieapp.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        val lstSlides: MutableList<Slide> = ArrayList()
        val lstMovie: MutableList<Movie> = ArrayList()

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val indicator: TabLayout = binding.indicator // this.findViewById(R.id.indicator)
        // Add more slides as necessary ---------------------------
        lstSlides.add(Slide(R.drawable.slide_1, "Avengers"))
        lstSlides.add(Slide(R.drawable.slide_2, "Ironman"))

        //---------------------------------------------------------

        // Add more movies ----------------------------------------
        lstMovie.add(Movie(R.drawable.slide_1, "Avengers"))
        lstMovie.add(Movie(R.drawable.slide_2, "Ironman"))
        lstMovie.add(Movie(R.drawable.slide_2, "Ironman"))
        lstMovie.add(Movie(R.drawable.slide_2, "Ironman"))
        lstMovie.add(Movie(R.drawable.slide_2, "Ironman"))
        lstMovie.add(Movie(R.drawable.slide_2, "Ironman"))
        lstMovie.add(Movie(R.drawable.slide_2, "Ironman"))
        lstMovie.add(Movie(R.drawable.slide_2, "Ironman"))
        //---------------------------------------------------------

        val sliderpager: ViewPager = binding.sliderPage //this.findViewById<ViewPager>(R.id.slider_page)
        sliderpager.adapter = SliderPagerAdapter(this, lstSlides)
        indicator.setupWithViewPager(sliderpager, true)

        // Set up the movie adapter
        val movieRV: RecyclerView = binding.RvMovies
        movieRV.adapter = MovieAdapter(this, lstMovie)
        movieRV.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)


        // Setting the viewbinding
        val view = binding.root
        setContentView(view)
    }
}

