package com.vintech.demo.data.local

import android.content.Context
import com.vintech.demo.di.ApplicationContext
import com.vintech.demo.di.DatabaseInfo
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DatabaseService @Inject constructor(
                      // context must be application context
    @ApplicationContext private val context: Context,
    @DatabaseInfo private val databaseName:String,
    @DatabaseInfo private val databaseVersion: Int
                     )

{
    val someData: String
    get() = "$databaseName $databaseVersion"
}