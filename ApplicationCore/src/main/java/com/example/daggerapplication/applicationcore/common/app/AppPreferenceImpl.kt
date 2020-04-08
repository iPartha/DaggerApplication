package com.example.daggerapplication.applicationcore.common.app

import android.app.Activity
import android.content.Context
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppPreferenceImpl @Inject constructor(private val context: Context) : AppPreference {
    private val prefEditor = context.getSharedPreferences("PREF_FILE", Activity.MODE_PRIVATE).edit()

    override fun <T> putPreference(key: String, value: T) {
        when(value) {
            is Int -> prefEditor.putInt(key, (value as Int))
            is Boolean -> prefEditor.putBoolean(key, (value as Boolean))
            is Long -> prefEditor.putLong(key, (value as Long))
            is String -> prefEditor.putString(key, (value as String))
        }
    }

    override fun <T> getPreference(key: String, defaultValue: T): T {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
