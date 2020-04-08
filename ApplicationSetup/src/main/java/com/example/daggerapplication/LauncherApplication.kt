package com.example.daggerapplication

import com.example.daggerapplication.applicationcore.di.DaggerAppComponent
import com.example.daggerapplication.di.DaggerAppDependenciesComponentImpl
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication


class LauncherApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val appDependencies = createAppDependenciesComponent()
        return DaggerAppComponent.builder().
            appDependenciesComponent(appDependencies).
            featureDependenciesComponent(appDependencies).
            build()
    }

    private fun createAppDependenciesComponent() = DaggerAppDependenciesComponentImpl.
        builder().
        appContext(this).
        build()

}