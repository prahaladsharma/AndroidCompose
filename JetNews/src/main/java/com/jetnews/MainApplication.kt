package com.jetnews

import android.app.Application
import com.jetnews.data.AppContainer
import com.jetnews.data.AppContainerImpl

class MainApplication : Application() {
    companion object{
        const val MAIN_URL = "https://developer.android.com/jetnews"
    }

    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppContainerImpl(this)
    }
}