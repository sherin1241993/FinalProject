package com.example.finalproject.api

import com.squareup.moshi.Json

data class Series(
    @Json(name = "available")
    val available: Int,
    @Json(name = "collectionURI")
    val collectionURI: String,
    @Json(name = "items")
    val items: List<ItemXX>,
    @Json(name = "returned")
    val returned: Int
)