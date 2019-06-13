package com.vintech.demo.ui.home



import com.mindorks.bootcamp.demo.utils.NetworkHelper
import com.vintech.demo.data.local.DatabaseService
import com.vintech.demo.data.remote.NetworkService
import com.vintech.demo.di.FragmentScope
import javax.inject.Inject

@FragmentScope
class HomeViewModel @Inject constructor(
    private val databaseService: DatabaseService,
    private val networkService: NetworkService,
    private val networkHelper: NetworkHelper

                   )
{
    val someData: String
    get() = "${databaseService.someData}"
}