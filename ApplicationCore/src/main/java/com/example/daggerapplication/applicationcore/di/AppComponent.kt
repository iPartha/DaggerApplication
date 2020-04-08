package com.example.daggerapplication.applicationcore.di

import com.example.daggerapplication.applicationcore.di.ui.ActivityDefinitionModule
import com.example.daggerapplication.applicationcore.di.ui.ViewModelFactoryModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [AppDependenciesComponent::class, FeatureDependenciesComponent::class],
    modules = [AndroidSupportInjectionModule::class,
        ActivityDefinitionModule::class,
        ViewModelFactoryModule::class]
)
interface AppComponent : AndroidInjector<DaggerApplication>
