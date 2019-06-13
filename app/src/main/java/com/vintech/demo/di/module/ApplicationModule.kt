package com.vintech.demo.di.module

import android.content.Context
import com.vintech.demo.BuildConfig
import com.vintech.demo.MyApplication
import com.vintech.demo.data.Networking
import com.vintech.demo.data.remote.NetworkService
import com.vintech.demo.di.ApplicationContext
import com.vintech.demo.di.DatabaseInfo
import com.vintech.demo.di.NetworkInfo
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: MyApplication) {

    @Provides
    @ApplicationContext
    fun provideContext(): Context = application

    @Provides
    @DatabaseInfo
    fun provideDatabaseName(): String = "xyz"

    @Provides
    @DatabaseInfo
    fun provideDatabaseVersion(): Int = 1


    @Provides
    @NetworkInfo
    fun provideNetworkKey(): String = "abc"

    @Provides
    fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()


    @Provides
    @Singleton
    fun provideNetworkService(): NetworkService{

        return Networking.create(BuildConfig.BASE_URL,
                                 BuildConfig.API_KEY,
                                 application.cacheDir,
                                 10 * 1024 * 1024)
    }
}