package com.example.finalproject.api

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Result(

    @Json(name = "comics")
    val comics: Comics,
    @Json(name = "description")
    val description: String,
    @Json(name = "events")
    val events: Events,
    @Json(name = "id")
    val id: Int,
    @Json(name = "modified")
    val modified: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "resourceURI")
    val resourceURI: String,
    @Json(name = "series")
    val series: Series,
    @Json(name = "stories")
    val stories: Stories,
    @Json(name = "thumbnail")
    val thumbnail: Thumbnail,
    @Json(name = "urls")
    val urls: List<Url>
)