package com.example.movieapp.views

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import com.example.movieapp.R
import com.example.movieapp.adapter.MovieAdapter
import com.example.movieapp.adapter.SliderPagerAdapter
import com.example.movieapp.databinding.ActivityMainBinding
import com.example.movieapp.interfaces.ButtonListener
import com.example.movieapp.interfaces.MovieItemClickListener
import com.example.movieapp.model.Movie
import com.example.movieapp.model.Slide
import com.example.movieapp.viewModels.mainViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MainActivity : AppCompatActivity(),
    MovieItemClickListener, ButtonListener {

    lateinit var binding: ActivityMainBinding
    private val viewModel : mainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        var lstSlides: ArrayList<Slide> = ArrayList()
        var lstMovie: ArrayList<Movie> = ArrayList()
        super.onCreate(savedInstanceState)
        supportActionBar?.hide();
        binding = ActivityMainBinding.inflate(layoutInflater)

        // set up the slider of highlight
        val sliderpager: RecyclerView = binding.slideRv
        val slideAdapter = SliderPagerAdapter(this, lstSlides, this)
        val helper: SnapHelper = LinearSnapHelper()
        helper.attachToRecyclerView(sliderpager)
        sliderpager.adapter = slideAdapter
        sliderpager.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        viewModel.loadSlides(lstSlides)
        viewModel.slidesLiveData.observe(this){
            lstSlides = it
            slideAdapter.notifyDataSetChanged()
        }

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

    }

    override fun onMovieClick(movie: Movie, movieImageView: ImageView?) {
        // Putting things into the intent to pass to next activity
        val intent = Intent(this, MovieDetailActivity::class.java)
        intent.putExtra("title", movie.title)
        intent.putExtra("imgURL", movie.thumbnail)
        intent.putExtra("ytURL", movie.ytURL)

        // Making the transition
        val options = ActivityOptions.makeSceneTransitionAnimation(this, movieImageView, "sharedName")

        startActivity(intent, options.toBundle())
    }
    override fun onSliderClick(slide : Slide, bt : FloatingActionButton){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.mainFrame, youtubeFragment())
            commit()
        }
        val options = ActivityOptions.makeSceneTransitionAnimation(this, findViewById(R.id.mainFrame),  "sharedName")
        var bundle = Bundle()
        val fragment = youtubeFragment()
        bundle.putString("videoId", slide.ytURL)
        bundle.putBundle("transition",options.toBundle())
        fragment.arguments = bundle
        val transaction = supportFragmentManager.beginTransaction().setCustomAnimations(
            R.anim.fade,
            R.anim.fade)
            .addToBackStack(null)
        transaction.replace(R.id.mainFrame, fragment)
        transaction.commit(
        )
        //Toast.makeText(this, "Clicked the button " + slide.title, Toast.LENGTH_LONG).show()
    }

    override fun onBackPressed() {
        super.onBackPressed()

        val intent =  Intent(this, MainActivity::class.java)
        val options = ActivityOptions.makeSceneTransitionAnimation(this, findViewById(R.id.mainFrame),  "sharedName")
        startActivity(intent, options.toBundle())
    }
}

