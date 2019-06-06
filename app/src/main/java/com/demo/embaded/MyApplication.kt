package com.demo.embaded

import android.app.Application
import android.util.Log
import com.demo.embaded.data.local.DatabaseService
import com.demo.embaded.data.remote.NetworkService
import com.demo.embaded.di.component.ApplicationComponent
import com.demo.embaded.di.component.DaggerApplicationComponent
import com.demo.embaded.di.module.ApplicationModule
import com.mindorks.bootcamp.demo.utils.NetworkHelper
import javax.inject.Inject

class MyApplication: Application(){

    lateinit var applicationComponent: ApplicationComponent

    @Inject
    lateinit var databaseService: DatabaseService

    @Inject
    lateinit var networkService: NetworkService

    @Inject
    lateinit var networkHelper: NetworkHelper

    override fun onCreate() {
        super.onCreate()
        getDependencies()
    }


    fun getDependencies(){

        applicationComponent = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()

        applicationComponent.inject(this)

        Log.d("DEBUG", databaseService.toString())

    }
}