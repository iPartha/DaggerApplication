package com.example.daggerapplication.applicationcore.di.ui

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module

@Module
interface ViewModelFactoryModule {

    @Binds
    fun bindViewModelFactory(factory: ViewModelProviderFactory) : ViewModelProvider.Factory
}