package com.example.daggerapplication.applicationcore.di

import com.example.daggerapplication.applicationcore.di.ui.startup.StartupDependenciesComponent

interface FeatureDependenciesComponent {
    fun providesStartupDependencies() : StartupDependenciesComponent
}