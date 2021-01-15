package com.example.msappkotlin.model

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class Movie (
    var title: String? = null,
    var image: String? = null,
    var rating: Double? = 0.0,
    var releaseYear: Int? = 0,
    var genre: List<String>? = null
): Parcelable



