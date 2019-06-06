package com.demo.embaded.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.Observer
import com.demo.embaded.MyApplication
import com.demo.embaded.R
import com.demo.embaded.di.component.DaggerActivityComponent
import com.demo.embaded.di.module.ActivityModule
import com.demo.embaded.ui.home.HomeFragment
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    companion object{
        const val TAG = "MainActivity"
    }

    @Inject
    lateinit var viewModel: MainViewModel

    lateinit var tvData: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        getDependencies()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()

        addHomeFragment()

        viewModel.allUsers.observe(this, Observer {

            tvData.text = it.toString()
        })
    }

    private fun init(){

        tvData = findViewById(R.id.tvData)

    }

    override fun onStop() {
        super.onStop()
        viewModel.deleteUser()
    }

    override fun onStart() {
        super.onStart()
        viewModel.getAllUser()
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.onDestroy()
    }

    private fun getDependencies(){

        DaggerActivityComponent.builder()
            .applicationComponent((application as MyApplication).applicationComponent)
            .activityModule(ActivityModule(this))
            .build()
            .inject(this)

        Log.d("DEBUG", viewModel.toString())
    }

    fun addHomeFragment(){

        if(supportFragmentManager.findFragmentByTag(HomeFragment.TAG) == null){

            supportFragmentManager.beginTransaction()
                .add(R.id.container_fragment, HomeFragment.getInstance(), HomeFragment.TAG)
                .commit()
        }
    }
}
