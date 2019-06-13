package com.vintech.demo.di.component

import com.mindorks.bootcamp.demo.utils.NetworkHelper
import com.vintech.demo.MyApplication
import com.vintech.demo.data.local.DatabaseService
import com.vintech.demo.data.remote.NetworkService
import com.vintech.demo.di.module.ApplicationModule
import dagger.Component
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(myApplication: MyApplication)

    fun getDatabaseService(): DatabaseService

    fun getNetworkService(): NetworkService

    fun getNetworkHelper(): NetworkHelper

    fun getCompositeDisposable(): CompositeDisposable
}