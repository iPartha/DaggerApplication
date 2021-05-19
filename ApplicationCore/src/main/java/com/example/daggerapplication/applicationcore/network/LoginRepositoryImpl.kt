package com.example.daggerapplication.applicationcore.network

import com.example.daggerapplication.applicationcore.common.app.AppPreference
import com.example.daggerapplication.applicationcore.startup.data.LoginDataSource
import com.example.daggerapplication.applicationcore.startup.data.LoginRepository
import com.example.daggerapplication.applicationcore.startup.data.Result
import com.example.daggerapplication.applicationcore.startup.data.model.LoggedInUser
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor (
    val dataSource: LoginDataSource, private val preference: AppPreference): LoginRepository {

    // in-memory cache of the loggedInUser object
    var user: LoggedInUser? = null
        private set

    val isLoggedIn: Boolean
        get() = user != null

    init {
        // If user credentials will be cached in local storage, it is recommended it be encrypted
        // @see https://developer.android.com/training/articles/keystore
        user = null
        if (user == null) {
            println("Partah sarath")
        }
    }

   override fun logout() {
        user = null
        dataSource.logout()
    }

    override fun login(username: String, password: String): Result<LoggedInUser> {
        // handle login
        val result = dataSource.login(username, password)

        if (result is Result.Success) {
            setLoggedInUser(result.data)
        }

        return result
    }

    private fun setLoggedInUser(loggedInUser: LoggedInUser) {
        this.user = loggedInUser
        preference.putPreference("Login_Status", "Success")
        // If user credentials will be cached in local storage, it is recommended it be encrypted
        // @see https://developer.android.com/training/articles/keystore
    }
}
