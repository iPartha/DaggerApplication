package com.example.daggerapplication.applicationcore.di.ui.startup

import com.example.daggerapplication.applicationcore.startup.data.LoginRepository

interface StartupDependenciesComponent {

    fun providesLoginRepository() : LoginRepository

}