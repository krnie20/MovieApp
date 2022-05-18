package com.example.movieapp.interfaces;

import android.widget.ImageView;
import com.example.movieapp.model.Movie;

public interface MovieItemClickListener {

    void onMovieClick(Movie movie, ImageView movieImageView); // we will need the imageview to make the shared animation.


}
