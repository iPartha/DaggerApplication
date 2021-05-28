package com.example.daggerapplication.applicationcore.home.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.daggerapplication.applicationcore.home.data.HomeRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

internal class HomeViewModel @Inject constructor(private val homeRepository: HomeRepository) : ViewModel() {

    fun getHomeMenuData() {
        viewModelScope.launch {
            homeRepository.getHomeMenuData()
        }
    }

}