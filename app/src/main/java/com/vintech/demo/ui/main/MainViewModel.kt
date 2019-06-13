package com.vintech.demo.ui.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.mindorks.bootcamp.demo.utils.NetworkHelper
import com.vintech.demo.data.Networking
import com.vintech.demo.data.local.DatabaseService
import com.vintech.demo.data.model.Dummy
import com.vintech.demo.data.remote.NetworkService
import com.vintech.demo.data.remote.request.DummyRequest
import com.vintech.demo.di.ActivityScope
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@ActivityScope
class MainViewModel @Inject constructor(
    private val compositeDisposable: CompositeDisposable,
    private val databaseService: DatabaseService,
    private val networkService: NetworkService,
    private val networkHelper: NetworkHelper)
{

    companion object{

        const val TAG = "MainViewModel"

    }

    val dummies = MutableLiveData<List<Dummy>>()

    fun getDummyCall(){

        compositeDisposable.add(
            networkService.doDummyCall(DummyRequest("123"))
                .subscribeOn(Schedulers.io())
                .subscribe(

                    {

                        dummies.postValue(it.data)
                    },
                    {

                        Log.d(TAG, it.toString())
                    }
                )
        )

    }


    /*fun getPostList(){

        compositeDisposable.add(

            networkService.doMyPostCall(Networking.API_KEY, )
        )
    }*/
}