package com.example.daggerapplication.applicationcore.di.ui.startup

import androidx.lifecycle.ViewModel
import com.example.daggerapplication.applicationcore.di.ui.ViewModelKey
import com.example.daggerapplication.applicationcore.startup.data.LoginRepository
import com.example.daggerapplication.applicationcore.startup.ui.login.LoginViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
class StartupScopeModule {

    @Provides
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    fun providesLoginViewModel(viewModel: LoginViewModel) : ViewModel {
        return viewModel
    }

    @StartupScope
    @Provides
    fun providesStartupRepository(dependenciesComponent: StartupDependenciesComponent) : LoginRepository {
        return dependenciesComponent.providesLoginRepository()
    }
}