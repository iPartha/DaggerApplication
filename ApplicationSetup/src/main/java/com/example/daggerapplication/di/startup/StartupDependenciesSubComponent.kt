package com.example.daggerapplication.di.startup

import com.example.daggerapplication.applicationcore.di.ui.startup.StartupDependenciesComponent
import dagger.Subcomponent

@Subcomponent(modules = [StartupModule::class])
interface StartupDependenciesSubComponent  : StartupDependenciesComponent {

    @Subcomponent.Builder
    interface Builder {
        fun build() : StartupDependenciesSubComponent
    }
}