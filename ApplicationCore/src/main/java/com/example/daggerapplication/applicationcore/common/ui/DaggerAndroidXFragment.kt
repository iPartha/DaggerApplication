package com.example.daggerapplication.applicationcore.common.ui

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

open class DaggerAndroidXFragment : Fragment(), HasAndroidInjector {

    @JvmField
    @Inject
    var androidInjector : DispatchingAndroidInjector<Any>? = null

    @JvmField
    @Inject
    var factory : ViewModelProvider.Factory? = null

    override fun androidInjector(): AndroidInjector<Any> {
        return androidInjector!!
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
        checkNotNull(androidInjector) {
            "Fragment ${javaClass.name} not properly initialized, missing injector"
        }

        checkNotNull(factory) {
            "Fragment ${javaClass.name} not properly initialized, missing factory"
        }
    }

    protected fun <T : ViewModel> getViewModel(modelClass : Class<T>, secondaryKey : String? = null) : T {
        val modelKey = if (secondaryKey.isNullOrEmpty()) {
            modelClass.canonicalName!!
        } else {
            modelClass.canonicalName +":"+secondaryKey
        }

        val provider = factory?.let {
            ViewModelProvider(this, it)
        } ?: ViewModelProvider(this)

        return provider[modelKey, modelClass]

    }

    protected fun <T : ViewModel> getActivityViewModel(modelClass : Class<T>, secondaryKey : String? = null) : T {
        val modelKey = if (secondaryKey.isNullOrEmpty()) {
            modelClass.canonicalName!!
        } else {
            modelClass.canonicalName +":"+secondaryKey
        }

        return activity?.run {
            factory?.let {
                ViewModelProvider(this, it)
            } ?: ViewModelProvider(this)
        } ?.get(modelKey, modelClass)
            ?: getViewModel(modelClass, secondaryKey)
    }

}