package com.example.movieapp

import com.example.movieapp.model.Slide
import com.google.android.material.floatingactionbutton.FloatingActionButton

interface ButtonListener {
    fun onSliderClick(slide : Slide, bt : FloatingActionButton)
}