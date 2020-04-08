package com.example.daggerapplication.applicationcore.startup.data

import com.example.daggerapplication.applicationcore.startup.data.model.LoggedInUser

/**
 * Class that requests authentication and user information from the remote data source and
 * maintains an in-memory cache of login status and user credentials information.
 */

interface LoginRepository {
    fun login(username: String, password: String): Result<LoggedInUser>
    fun logout()
}