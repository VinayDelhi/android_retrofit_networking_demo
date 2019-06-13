package com.vintech.demo.di.module

import android.app.Activity
import android.content.Context
import com.vintech.demo.di.ActivityContext
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private val activity: Activity) {

    @Provides
    @ActivityContext
    fun provideContext(): Context = activity
}