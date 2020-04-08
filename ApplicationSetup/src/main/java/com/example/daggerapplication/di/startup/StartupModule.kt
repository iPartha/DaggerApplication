package com.example.daggerapplication.di.startup

import com.example.daggerapplication.applicationcore.network.LoginRepositoryImpl
import com.example.daggerapplication.applicationcore.startup.data.LoginRepository
import dagger.Binds
import dagger.Module

@Module
interface StartupModule {
    @Binds
    fun provideStartupRepository(repository: LoginRepositoryImpl) : LoginRepository
}