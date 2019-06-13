package com.vintech.demo.di.component

import com.vintech.demo.di.ActivityScope
import com.vintech.demo.di.module.ActivityModule
import com.vintech.demo.ui.main.MainActivity
import dagger.Component


@ActivityScope
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {

    fun inject(mainActivity: MainActivity)
}