package com.example.daggerapplication.applicationcore.di.ui

import com.example.daggerapplication.applicationcore.di.ui.startup.StartupScope
import com.example.daggerapplication.applicationcore.di.ui.startup.StartupScopeModule
import com.example.daggerapplication.applicationcore.startup.ui.login.StartupActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivityDefinitionModule {

    @ContributesAndroidInjector(modules = [StartupScopeModule::class])
    @StartupScope
    fun injectToStartupActivity() : StartupActivity
}