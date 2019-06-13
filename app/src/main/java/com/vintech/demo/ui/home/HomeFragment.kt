package com.vintech.demo.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.vintech.demo.MyApplication
import com.vintech.demo.R
import com.vintech.demo.di.ApplicationContext
import com.vintech.demo.di.component.DaggerFragmentComponent
import com.vintech.demo.di.module.FragmentModule
import com.vintech.demo.ui.main.MainActivity
import javax.inject.Inject

class HomeFragment: Fragment() {

           companion object{
               const val TAG = "HomeFragment"

               fun getInstance(): HomeFragment{

                   val fragment = HomeFragment()

                   val arg = Bundle()
                   fragment.arguments = arg

                   return fragment
               }
           }

    @Inject
    lateinit var homeViewModel: HomeViewModel

    lateinit var tvData: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        getDependencies()
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init(view)

    }

    fun init(view: View){

        tvData = view.findViewById(R.id.tv_message)
        tvData.text = homeViewModel.someData
    }

    fun getDependencies(){

        DaggerFragmentComponent.builder()
            .applicationComponent((context!!.applicationContext as MyApplication).applicationComponent)
            .fragmentModule(FragmentModule(this))
            .build()
            .inject(this)

        Log.d(TAG, homeViewModel.someData)
    }
}