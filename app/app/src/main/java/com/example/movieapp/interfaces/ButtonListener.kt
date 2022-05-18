package com.example.movieapp.interfaces

import com.example.movieapp.model.Slide
import com.google.android.material.floatingactionbutton.FloatingActionButton

interface ButtonListener {
    fun onSliderClick(slide : Slide, bt : FloatingActionButton)
}