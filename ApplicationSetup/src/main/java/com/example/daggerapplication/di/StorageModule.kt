package com.example.daggerapplication.di

import com.example.daggerapplication.applicationcore.common.app.AppPreference
import com.example.daggerapplication.applicationcore.common.app.AppPreferenceImpl
import dagger.Binds
import dagger.Module

@Module
interface StorageModule {
    @Binds
    fun bindAppPreference(preference: AppPreferenceImpl) : AppPreference
}