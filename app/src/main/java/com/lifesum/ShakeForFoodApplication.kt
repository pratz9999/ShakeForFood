package com.lifesum

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Base class of Android app containing components like Activities and Services
 * Instantiated before all the activities or any other application objects have been created in Android app
 */
@HiltAndroidApp
class ShakeForFoodApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        lateinit var instance: ShakeForFoodApplication
            private set
    }
}