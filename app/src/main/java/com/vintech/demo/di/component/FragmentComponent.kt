package com.vintech.demo.di.component

import com.vintech.demo.di.FragmentScope
import com.vintech.demo.di.module.FragmentModule
import com.vintech.demo.ui.home.HomeFragment
import dagger.Component

@FragmentScope
@Component(dependencies = [ApplicationComponent::class], modules = [FragmentModule::class])
interface FragmentComponent {

    fun inject(homeFragment: HomeFragment)

}