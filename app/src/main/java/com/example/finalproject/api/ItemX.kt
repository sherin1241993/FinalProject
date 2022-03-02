package com.example.finalproject.api

import com.squareup.moshi.Json

data class ItemX(
    @Json(name = "name")
    val name: String,
    @Json(name = "resourceURI")
    val resourceURI: String
)