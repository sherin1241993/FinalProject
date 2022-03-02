package com.example.finalproject.api

import com.squareup.moshi.Json

data class Stories(
    @Json(name = "available")
    val available: Int,
    @Json(name = "collectionURI")
    val collectionURI: String,
    @Json(name = "items")
    val items: List<ItemXXX>,
    @Json(name = "returned")
    val returned: Int
)