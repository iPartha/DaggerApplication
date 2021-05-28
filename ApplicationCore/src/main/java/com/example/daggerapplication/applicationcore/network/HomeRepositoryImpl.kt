package com.example.daggerapplication.applicationcore.network

import android.util.Log
import com.example.daggerapplication.applicationcore.home.data.HomeRepository
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(private val homeService: HomeService) : HomeRepository {
    override suspend fun getHomeMenuData(): Any {
        val data = homeService.getHomeMenu("https://my-json-server.typicode.com/iPartha/rest/db")
        Log.i("Ho", "Home data "+data)
        return data
    }

}