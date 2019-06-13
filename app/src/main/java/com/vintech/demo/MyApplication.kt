package com.vintech.demo

import android.app.Application
import android.util.Log
import com.mindorks.bootcamp.demo.utils.NetworkHelper
import com.vintech.demo.data.local.DatabaseService
import com.vintech.demo.data.remote.NetworkService
import com.vintech.demo.di.component.ApplicationComponent
import com.vintech.demo.di.component.DaggerApplicationComponent
import com.vintech.demo.di.module.ApplicationModule
import javax.inject.Inject

class MyApplication: Application() {

    lateinit var applicationComponent: ApplicationComponent

    companion object{
        const val TAG = "MyApplication"
    }

    @Inject
    lateinit var databaseService: DatabaseService

    @Inject
    lateinit var networkService: NetworkService

    @Inject
    lateinit var networkHelper: NetworkHelper

    override fun onCreate() {
        super.onCreate()
        getDependencies()
    }


    private fun getDependencies(){

        applicationComponent = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()

        applicationComponent.inject(this)

        Log.d(TAG, "${databaseService.someData}")
    }
}