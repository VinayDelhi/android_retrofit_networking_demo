package com.vintech.demo.di

import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.SOURCE)
annotation class ActivityScope

@Scope
@Retention(AnnotationRetention.SOURCE)
annotation class FragmentScope
