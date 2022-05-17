package com.example.movieapp

import android.annotation.SuppressLint
import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.movieapp.adapter.MovieAdapter
import com.example.movieapp.adapter.SliderPagerAdapter
import com.example.movieapp.databinding.ActivityMainBinding
import com.example.movieapp.model.Movie
import com.example.movieapp.model.Slide
import com.example.movieapp.viewModels.mainViewModel
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity(), MovieItemClickListener {

    lateinit var binding: ActivityMainBinding
    private val viewModel : mainViewModel by viewModels()
    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        var lstSlides: ArrayList<Slide> = ArrayList()
        var lstMovie: ArrayList<Movie> = ArrayList()
        super.onCreate(savedInstanceState)
        supportActionBar?.hide();
        binding = ActivityMainBinding.inflate(layoutInflater)
        val indicator: TabLayout = binding.indicator // this.findViewById(R.id.indicator)

        // set up the slider of highlight
        val sliderpager: ViewPager = binding.sliderPage
        val slideAdapter = SliderPagerAdapter(this, lstSlides)
        sliderpager.adapter = slideAdapter
        viewModel.loadSlides(lstSlides)
        viewModel.slidesLiveData.observe(this){
            lstSlides = it
            slideAdapter.notifyDataSetChanged()
        }
        indicator.setupWithViewPager(sliderpager, true)

        // Set up the movie adapter
        val movieRV: RecyclerView = binding.RvMovies
        val movieAdapter =  MovieAdapter(this, lstMovie, this)
        movieRV.adapter = movieAdapter
        movieRV.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        viewModel.loadMovies(lstMovie)
        viewModel.moviesLiveData.observe(this){
            lstMovie = it
            movieAdapter.notifyDataSetChanged()
        }
        // Setting the viewbinding
        val view = binding.root
        setContentView(view)

        // FragmentsTestActivity
        val fragmentsTestButton = findViewById<Button>(R.id.fragments_test_button)
        fragmentsTestButton.setOnClickListener {
            val intent = Intent(this,FragmentsTestActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onMovieClick(movie: Movie, movieImageView: ImageView?) {
        // Putting things into the intent to pass to next activity
        val intent = Intent(this, MovieDetailActivity::class.java)
        intent.putExtra("title", movie.title)
        intent.putExtra("imgURL", movie.thumbnail)
        intent.putExtra("imgCover", movie.coverPhoto)

        // Making the transition
        val options = ActivityOptions.makeSceneTransitionAnimation(this, movieImageView, "sharedName")

        startActivity(intent, options.toBundle())
        Toast.makeText(this, "Clicked: "+ movie.title, Toast.LENGTH_LONG).show()
    }

    fun createData(){


    }
}

