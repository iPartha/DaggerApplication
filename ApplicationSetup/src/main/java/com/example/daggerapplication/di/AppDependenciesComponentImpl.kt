package com.example.daggerapplication.di

import android.content.Context
import com.example.daggerapplication.applicationcore.di.AppDependenciesComponent
import com.example.daggerapplication.applicationcore.di.FeatureDependenciesComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [FeatureModule::class, StorageModule::class, NetworkModule::class])
interface AppDependenciesComponentImpl : AppDependenciesComponent, FeatureDependenciesComponent {

    @Component.Builder
    interface AppComponentBuilder {

        @BindsInstance
        fun appContext(context: Context) : AppComponentBuilder

        fun build() :AppDependenciesComponentImpl
    }
}