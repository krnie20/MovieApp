package com.example.movieapp

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.movieapp.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity(), MovieItemClickListener {

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
        lstMovie.add(Movie(R.drawable.slide_1,"Avengers", R.drawable.slide_1))
        lstMovie.add(Movie(R.drawable.slide_2, "Ironman", R.drawable.slide_1))
        lstMovie.add(Movie(R.drawable.slide_1, "Avengers", R.drawable.slide_2))
        lstMovie.add(Movie(R.drawable.slide_2, "Ironman", R.drawable.slide_1))
        lstMovie.add(Movie(R.drawable.slide_1, "Avengers", R.drawable.slide_2))
        lstMovie.add(Movie(R.drawable.slide_2, "Ironman", R.drawable.slide_1))
        //---------------------------------------------------------

        val sliderpager: ViewPager = binding.sliderPage //this.findViewById<ViewPager>(R.id.slider_page)
        sliderpager.adapter =
            SliderPagerAdapter(this, lstSlides)
        indicator.setupWithViewPager(sliderpager, true)

        // Set up the movie adapter
        val movieRV: RecyclerView = binding.RvMovies
        movieRV.adapter =
            MovieAdapter(this, lstMovie, this)
        movieRV.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        // Setting the viewbinding
        val view = binding.root
        setContentView(view)
    }

    override fun onMovieClick(movie: Movie, movieImageView: ImageView?) {
        // Putting things into the intent to pass to next activity
        val intent = Intent(this, MovieDetailActivity::class.java)
        intent.putExtra("title", movie.title)
        intent.putExtra("imgURL", movie.thumbnail)
        intent.getIntExtra("imgCover", movie.coverPhoto)

        // Making the transition
        val options = ActivityOptions.makeSceneTransitionAnimation(this, movieImageView, "sharedName")

        startActivity(intent, options.toBundle())
        Toast.makeText(this, "Clicked: "+ movie.title, Toast.LENGTH_LONG).show()
    }
}

