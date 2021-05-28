package com.example.daggerapplication.applicationcore.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.converter.moshi.MoshiConverterFactory

class RestClient {

    companion object {

        fun getJsonConverter() : Converter.Factory {
            val moshiBuilder = Moshi.Builder()
            moshiBuilder.add(KotlinJsonAdapterFactory())
            return MoshiConverterFactory.create(moshiBuilder.build())
        }

        fun getHttpClient() : OkHttpClient {
            return OkHttpClient().newBuilder().build()
        }
    }
}