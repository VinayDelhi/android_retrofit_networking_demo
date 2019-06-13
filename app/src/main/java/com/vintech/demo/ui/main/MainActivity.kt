package com.vintech.demo.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.Observer
import com.vintech.demo.MyApplication
import com.vintech.demo.R
import com.vintech.demo.di.component.DaggerActivityComponent
import com.vintech.demo.di.module.ActivityModule
import com.vintech.demo.ui.home.HomeFragment
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    companion object{
        const val TAG = "MainActivity"
    }

    @Inject
    lateinit var viewModel: MainViewModel

    private lateinit var tvData: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        getDependencies()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        addHomeFragment()

        viewModel.dummies.observe(this, Observer {

            tvData.text = it.toString()
        })

        viewModel.getDummyCall()
    }

    private fun init(){
        tvData = findViewById(R.id.tv_message)
    }

    private fun getDependencies(){

        DaggerActivityComponent.builder()
            .applicationComponent((application as MyApplication).applicationComponent)
            .activityModule(ActivityModule(this))
            .build()
            .inject(this)
    }

    fun addHomeFragment(){

        if(supportFragmentManager.findFragmentByTag(TAG) == null){
            supportFragmentManager.beginTransaction()
                .add(R.id.container_fragment, HomeFragment.getInstance(), HomeFragment.TAG)
                .commit()
        }
    }
}
