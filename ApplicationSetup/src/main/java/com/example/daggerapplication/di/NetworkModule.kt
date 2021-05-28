package com.example.daggerapplication.di

import com.example.daggerapplication.applicationcore.home.data.HomeRepository
import com.example.daggerapplication.applicationcore.network.HomeRepositoryImpl
import com.example.daggerapplication.applicationcore.network.HomeService
import com.example.daggerapplication.applicationcore.network.RestClient
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    fun providesHomeApi(retrofit: Retrofit) : HomeService = retrofit.create(HomeService::class.java)

    @Provides
    fun providesHomeDataRepository(homeService: HomeService) : HomeRepository = HomeRepositoryImpl(homeService)

    @Singleton
    @Provides
    fun provideRetrofitInstance() : Retrofit = Retrofit.Builder().
        baseUrl("https://my-json-server.typicode.com/iPartha/rest").
        client(RestClient.getHttpClient()).
        addConverterFactory(RestClient.getJsonConverter())
        .build()
}