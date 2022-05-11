package com.example.movieapp;

import android.widget.ImageView;

import com.example.movieapp.item.Movie;

public interface MovieItemClickListener {

    void onMovieClick(Movie movie, ImageView movieImageView); // we will need the imageview to make the shared animation.


}
