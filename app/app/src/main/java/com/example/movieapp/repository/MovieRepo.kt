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
               "n9xhJrPXop4"))
           movies.add(Movie("https://m.media-amazon.com/images/M/MV5BMDdmMTBiNTYtMDIzNi00NGVlLWIzMDYtZTk3MTQ3NGQxZGEwXkEyXkFqcGdeQXVyMzMwOTU5MDk@._V1_FMjpg_UX1000_.jpg",
               "The Batman",
               "NLOp_6uPccQ"))
           movies.add(Movie("https://m.media-amazon.com/images/M/MV5BMWEwNjhkYzYtNjgzYy00YTY2LThjYWYtYzViMGJkZTI4Y2MyXkEyXkFqcGdeQXVyNTM0OTY1OQ@@._V1_FMjpg_UX1000_.jpg",
               "Uncharted",
               "eHp3MbsCbMg"))
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