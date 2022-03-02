package com.example.finalproject.api

import com.squareup.moshi.Json

data class ItemXXX(
    @Json(name = "name")
    val name: String,
    @Json(name = "resourceURI")
    val resourceURI: String,
    @Json(name = "type")
    val type: String
)