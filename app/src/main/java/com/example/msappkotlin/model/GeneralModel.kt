package com.example.msappkotlin.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ServerResponse<T>(
    var code: Int = 0,
    var message: String? = null,
    var data: T? = null
)
