package com.example.movieapp

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.movieapp.adapter.MovieAdapter
import com.example.movieapp.adapter.SliderPagerAdapter
import com.example.movieapp.databinding.ActivityMainBinding
import com.example.movieapp.item.Movie
import com.example.movieapp.item.Slide
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity(), MovieItemClickListener {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        val lstSlides: MutableList<Slide> = ArrayList()
        val lstMovie: MutableList<Movie> = ArrayList()
        super.onCreate(savedInstanceState)
        supportActionBar?.hide();
        binding = ActivityMainBinding.inflate(layoutInflater)
        val indicator: TabLayout = binding.indicator // this.findViewById(R.id.indicator)
        // Add more slides as necessary ---------------------------

        lstSlides.add(Slide("https://m.media-amazon.com/images/M/MV5BMWEwNjhkYzYtNjgzYy00YTY2LThjYWYtYzViMGJkZTI4Y2MyXkEyXkFqcGdeQXVyNTM0OTY1OQ@@._V1_FMjpg_UX1000_.jpg",
                            "Uncharted"))
        lstSlides.add(Slide("https://m.media-amazon.com/images/M/MV5BMDdmMTBiNTYtMDIzNi00NGVlLWIzMDYtZTk3MTQ3NGQxZGEwXkEyXkFqcGdeQXVyMzMwOTU5MDk@._V1_FMjpg_UX1000_.jpg",
                            "Batman"))
        lstSlides.add(Slide("https://m.media-amazon.com/images/M/MV5BN2FjNmEyNWMtYzM0ZS00NjIyLTg5YzYtYThlMGVjNzE1OGViXkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_FMjpg_UX1000_.jpg",
            "Dune"))
        //---------------------------------------------------------

        // Add more movies ----------------------------------------
        lstMovie.add(Movie("https://m.media-amazon.com/images/M/MV5BN2FjNmEyNWMtYzM0ZS00NjIyLTg5YzYtYThlMGVjNzE1OGViXkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_FMjpg_UX1000_.jpg",
            "Dune",
            "https://m.media-amazon.com/images/M/MV5BOWQ1NTU0NjMtZmE3Ni00OTkxLTk4YTItM2I2ZmIwOGM4M2YzXkEyXkFqcGdeQXVyNzI1NzMxNzM@._V1_FMjpg_UX1000_.jpg"))
        lstMovie.add(Movie("https://m.media-amazon.com/images/M/MV5BMDdmMTBiNTYtMDIzNi00NGVlLWIzMDYtZTk3MTQ3NGQxZGEwXkEyXkFqcGdeQXVyMzMwOTU5MDk@._V1_FMjpg_UX1000_.jpg",
            "Batman",
            "https://m.media-amazon.com/images/M/MV5BOTAyMGVhMDItYjY3Yy00N2NkLThjMDEtOWRiMDI3Nzc4ZjEyXkEyXkFqcGdeQXVyMTEyMjM2NDc2._V1_FMjpg_UX1000_.jpg"))
        lstMovie.add(Movie("https://m.media-amazon.com/images/M/MV5BMWEwNjhkYzYtNjgzYy00YTY2LThjYWYtYzViMGJkZTI4Y2MyXkEyXkFqcGdeQXVyNTM0OTY1OQ@@._V1_FMjpg_UX1000_.jpg",
            "Uncharted",
            "https://m.media-amazon.com/images/M/MV5BMjJjNmU5MmItYThjMi00NDU5LTg2NzItMjFiNmUwNTQxY2I2XkEyXkFqcGdeQXVyMjkwMjE3Mjk@._V1_FMjpg_UX1000_.jpg"))
        //lstMovie.add(Movie(R.drawable.slide_2, "Ironman", R.drawable.slide_2))
        //lstMovie.add(Movie(R.drawable.slide_1, "Avengers", R.drawable.slide_1))
        //lstMovie.add(Movie(R.drawable.slide_2, "Ironman", R.drawable.slide_2))
        //---------------------------------------------------------

        val sliderpager: ViewPager = binding.sliderPage //this.findViewById<ViewPager>(R.id.slider_page)
        sliderpager.adapter = SliderPagerAdapter(this, lstSlides)
        indicator.setupWithViewPager(sliderpager, true)

        // Set up the movie adapter
        val movieRV: RecyclerView = binding.RvMovies
        movieRV.adapter = MovieAdapter(this, lstMovie, this)
        movieRV.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

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
}

