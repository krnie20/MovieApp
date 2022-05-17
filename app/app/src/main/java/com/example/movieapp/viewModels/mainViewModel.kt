package com.example.movieapp.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movieapp.model.Movie
import com.example.movieapp.model.Slide
import com.example.movieapp.repository.MovieRepo

class mainViewModel: ViewModel() {
    private val repo = MovieRepo()
    val moviesLiveData: MutableLiveData<ArrayList<Movie>> = repo.moviesLiveData
    val slidesLiveData: MutableLiveData<ArrayList<Slide>> = repo.slidesLiveData

    fun loadMovies(movieList: ArrayList<Movie>){
        repo.loadMovies(movieList)
    }

    fun loadSlides(slideList: ArrayList<Slide>){
        repo.loadSlides(slideList)
    }
}