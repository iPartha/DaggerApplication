package com.example.daggerapplication.applicationcore.common.app

interface AppPreference {
    fun <T> putPreference(key : String, value : T)
    fun <T> getPreference(key: String, defaultValue : T) : T
}