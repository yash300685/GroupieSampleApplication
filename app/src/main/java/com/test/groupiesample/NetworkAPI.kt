package com.test.groupiesample

import retrofit2.http.GET

interface NetworkAPI {

    @GET("tv/top_rated?api_key=65013a095c6cbfd30b05afb9e9b6f69a&language=en-US&page=1")
   suspend fun getTvShows():tvmodel
}