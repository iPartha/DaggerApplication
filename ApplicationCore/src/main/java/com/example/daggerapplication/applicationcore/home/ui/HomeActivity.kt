package com.example.daggerapplication.applicationcore.home.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.daggerapplication.applicationcore.R
import com.example.daggerapplication.applicationcore.common.ui.DaggerFragmentActivity
import com.example.daggerapplication.applicationcore.startup.ui.login.LoginViewModel

class HomeActivity : DaggerFragmentActivity() {

    private val homeViewModel: HomeViewModel by lazy {
        getViewModel(HomeViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("Partha Test")
        setContentView(R.layout.activity_home)
        homeViewModel.getHomeMenuData()
    }
}
