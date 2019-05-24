package com.example.examplemvp.http

import com.example.examplemvp.http.apimodel.JsonRoot
import retrofit2.http.GET
import retrofit2.Call
import retrofit2.http.Headers

interface TwitchAPI {

    @Headers(
        "Client-ID: zqj6nhqza26k144gh7ba95stl0cb8u"
    )

    @GET("helix/streams?game_id=33214")
    fun getRoot(): Call<JsonRoot>
}