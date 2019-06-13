package com.vintech.demo.data

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.vintech.demo.BuildConfig
import com.vintech.demo.data.remote.NetworkService
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit

/**
 * 1.addBaseUrl()
 * 2.cache(Cache(cacheDir, cacheSize): is use to cache the response in
 * files in local. It take file location and size of cache.
 *
 * 3.addInterceptor(HttpLoggingInterceptor()): used for logging request
 * and response.We need to loggin request & response for Debug build.
 * BuildConfig has the information of build type as "BuildConfig.DEBUG".
 *
 * We can define level of loggin request & response like "HttpLoggingInterceptor.Level.BODY"
 *
 * 4.addConverterFactory(GsonConverterFactory.create()): is used for
 * convert JSON format response in specified object type
 *
 * 5.addCallAdapterFactory(RxJava2CallAdapterFactory.create()): Is used for
 * convert String response in Observable Type. Http response is simply
 * a string response. So we convert this string response in Observable
 * forcely by using addCallAdapterFactory(RxJava2CallAdapterFactory)
 *
 *
 *
 *
 * */
object Networking {

    const val HEADER_API_KEY = "x-api-key"
    const val HEADER_ACCESS_TOKEN = "x-access-token"
    const val HEADER_USER_ID = "x-user-id"

    private const val NETWORK_TIME_OUT = 60

    lateinit var API_KEY: String


    fun create(baseUrl: String, apiKey: String, cacheDir: File, cacheSize: Long): NetworkService {
        API_KEY=apiKey
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(

                OkHttpClient.Builder()
                    .cache(Cache(cacheDir, cacheSize))
                        /**
                         * Conguring loggin interceptor only for
                         * debug build. BuildConfig has the build type.
                         * So we are loggin request & response, body
                         * level http interceptor.
                         * */

                    .addInterceptor(HttpLoggingInterceptor()
                        .apply {
                            level = if(BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
                            else HttpLoggingInterceptor.Level.NONE
                        })
                    .readTimeout(NETWORK_TIME_OUT.toLong(), TimeUnit.SECONDS)
                    .writeTimeout(NETWORK_TIME_OUT.toLong(), TimeUnit.SECONDS)
                    .build()
            )
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(NetworkService::class.java)
    }


}