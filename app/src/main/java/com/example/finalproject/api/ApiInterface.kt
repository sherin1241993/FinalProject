package com.example.finalproject.api

import retrofit2.http.*

interface ApiInterface {
    // notation
   @GET("v1/public/characters?apikey=387eb6d01c12be4d61aae3a6c3d32c4d&hash=ccaf903ba02c29b6182959d0208d8bc1&ts=11:42:35")
    suspend fun getData():retrofit2.Response<Response>

    @GET("v1/public/characters/{id}?apikey=387eb6d01c12be4d61aae3a6c3d32c4d&hash=ccaf903ba02c29b6182959d0208d8bc1&ts=11:42:35")
    suspend fun getDetails(@Path("id") id: Int?):retrofit2.Response<Response>

}