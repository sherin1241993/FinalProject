package com.example.finalproject.api

import com.squareup.moshi.Json

data class Thumbnail(
    @Json(name = "extension")
    val extension: String,
    @Json(name = "path")
    val path: String
)