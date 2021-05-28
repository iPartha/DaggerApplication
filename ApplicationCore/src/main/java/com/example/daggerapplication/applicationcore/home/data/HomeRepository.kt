package com.example.daggerapplication.applicationcore.home.data

interface HomeRepository {
    suspend fun getHomeMenuData() : Any
}