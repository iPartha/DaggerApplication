package com.example.daggerapplication.applicationcore.di

import com.example.daggerapplication.applicationcore.home.data.HomeRepository

interface AppDependenciesComponent {

    fun providesHomeDataRepository() : HomeRepository

}