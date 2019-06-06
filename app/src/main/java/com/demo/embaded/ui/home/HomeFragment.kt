package com.demo.embaded.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.demo.embaded.MyApplication
import com.demo.embaded.R
import com.demo.embaded.di.ApplicationContext
import com.demo.embaded.di.component.DaggerFragmentComponent
import com.demo.embaded.di.module.FragmentModule
import javax.inject.Inject

class HomeFragment: Fragment() {

    companion object{
        const val TAG = "HomeFragment"

        fun getInstance(): HomeFragment{

            val homeFragment = HomeFragment()
            val arg = Bundle()
            homeFragment.arguments = arg

            return homeFragment
        }
    }

    private lateinit var tvData: TextView

    @Inject
    lateinit var homeViewModel: HomeViewModel

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

        tvData = view.findViewById(R.id.tvData)

        tvData.text = homeViewModel.someData

    }


    fun getDependencies(){

        DaggerFragmentComponent.builder()
            .applicationComponent((context!!.applicationContext as MyApplication).applicationComponent)
            .fragmentModule(FragmentModule(this))
            .build()
            .inject(this)

        Log.d("DEBUG", homeViewModel.toString())
    }


}