package com.example.movieapp.repository

import androidx.lifecycle.MutableLiveData
import com.example.movieapp.model.Movie
import com.example.movieapp.model.Slide

class MovieRepo {
    val moviesLiveData: MutableLiveData<ArrayList<Movie>> = MutableLiveData()
    val slidesLiveData: MutableLiveData<ArrayList<Slide>> = MutableLiveData()
    private val movies: ArrayList<Movie> = ArrayList()
    private val slides: ArrayList<Slide> = ArrayList()

   init {
       // Movies are for the recycler view
       if (movies.isEmpty()){
           movies.add(Movie("https://m.media-amazon.com/images/M/MV5BN2FjNmEyNWMtYzM0ZS00NjIyLTg5YzYtYThlMGVjNzE1OGViXkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_FMjpg_UX1000_.jpg",
               "Dune",
               "https://m.media-amazon.com/images/M/MV5BOWQ1NTU0NjMtZmE3Ni00OTkxLTk4YTItM2I2ZmIwOGM4M2YzXkEyXkFqcGdeQXVyNzI1NzMxNzM@._V1_FMjpg_UX1000_.jpg"))
           movies.add(Movie("https://m.media-amazon.com/images/M/MV5BMDdmMTBiNTYtMDIzNi00NGVlLWIzMDYtZTk3MTQ3NGQxZGEwXkEyXkFqcGdeQXVyMzMwOTU5MDk@._V1_FMjpg_UX1000_.jpg",
               "Batman",
               "https://m.media-amazon.com/images/M/MV5BOTAyMGVhMDItYjY3Yy00N2NkLThjMDEtOWRiMDI3Nzc4ZjEyXkEyXkFqcGdeQXVyMTEyMjM2NDc2._V1_FMjpg_UX1000_.jpg"))
           movies.add(Movie("https://m.media-amazon.com/images/M/MV5BMWEwNjhkYzYtNjgzYy00YTY2LThjYWYtYzViMGJkZTI4Y2MyXkEyXkFqcGdeQXVyNTM0OTY1OQ@@._V1_FMjpg_UX1000_.jpg",
               "Uncharted",
               "https://m.media-amazon.com/images/M/MV5BMjJjNmU5MmItYThjMi00NDU5LTg2NzItMjFiNmUwNTQxY2I2XkEyXkFqcGdeQXVyMjkwMjE3Mjk@._V1_FMjpg_UX1000_.jpg"))
       }
       // Slides are the highlights
       if (slides.isEmpty()){
           slides.add(Slide("https://m.media-amazon.com/images/M/MV5BMWEwNjhkYzYtNjgzYy00YTY2LThjYWYtYzViMGJkZTI4Y2MyXkEyXkFqcGdeQXVyNTM0OTY1OQ@@._V1_FMjpg_UX1000_.jpg",
               "Uncharted"))
           slides.add(Slide("https://m.media-amazon.com/images/M/MV5BMDdmMTBiNTYtMDIzNi00NGVlLWIzMDYtZTk3MTQ3NGQxZGEwXkEyXkFqcGdeQXVyMzMwOTU5MDk@._V1_FMjpg_UX1000_.jpg",
               "Batman"))
           slides.add(Slide("https://m.media-amazon.com/images/M/MV5BN2FjNmEyNWMtYzM0ZS00NjIyLTg5YzYtYThlMGVjNzE1OGViXkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_FMjpg_UX1000_.jpg",
               "Dune"))
       }
   }
    fun loadMovies(movieList: ArrayList<Movie>){
        movieList.clear()
        for (movie in movies){
            movieList.add(movie)
        }
        moviesLiveData.postValue(movieList)
    }
    fun loadSlides(slideList: ArrayList<Slide>){
        slideList.clear()
        for (slide in slides){
            slideList.add(slide)
        }
        slidesLiveData.postValue(slideList)
    }
}