package com.example.daggerapplication.di

import com.example.daggerapplication.applicationcore.common.app.AppPreference
import com.example.daggerapplication.applicationcore.di.ui.startup.StartupDependenciesComponent
import com.example.daggerapplication.applicationcore.network.LoginRepositoryImpl
import com.example.daggerapplication.applicationcore.startup.data.LoginDataSource
import com.example.daggerapplication.di.startup.StartupDependenciesSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [StartupDependenciesSubComponent::class])
class FeatureModule {

    @Singleton
    @Provides
    fun providesStartupDependencies(dependencies : StartupDependenciesSubComponent.Builder) : StartupDependenciesComponent =
        dependencies.build()

    @Provides
    fun provideStartupRepository(dataSource: LoginDataSource, preference: AppPreference)  = LoginRepositoryImpl(dataSource, preference)

    @Provides
    fun providesLoginDataSource() = LoginDataSource()
}