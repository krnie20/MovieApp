package com.example.movieapp.item

class Movie {
    var title: String
    var description: String? = null
    var thumbnail: String
    var studio: String? = null
    var rating: String? = null
    var streamingLink: String? = null
    var coverPhoto: String

    constructor(thumbnail: String, title: String, coverPhoto: String) {
        this.title = title
        this.thumbnail = thumbnail
        this.coverPhoto = coverPhoto
    }

}