package com.example.daggerapplication.applicationcore.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url
import java.lang.StringBuilder

interface HomeService {
    @GET
    suspend fun getHomeMenu(@Url url : String) : Response<Any>
}