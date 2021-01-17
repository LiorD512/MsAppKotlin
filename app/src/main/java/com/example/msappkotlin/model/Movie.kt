package com.example.msappkotlin.model

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

//@JsonClass(generateAdapter = true)
//@Parcelize
//data class Movie (
//    var title: String? = null,
//    var image: String? = null,
//    var rating: Double? = 0.0,
//    var releaseYear: Int? = 0,
//    var genre: List<String>? = null
//): Parcelable


@JsonClass(generateAdapter = true)
@Parcelize
data class Movie (
    var title: String?,
    var image: String?,
    var rating: Double? ,
    var releaseYear: Int?,
    var genre: List<String>?
): Parcelable

// todo: No need for default value when using nullable Object - will be used on no nullable so there will be a default value in case of null from server





