package com.demo.embaded.di.component

import com.demo.embaded.MyApplication
import com.demo.embaded.data.local.DatabaseService
import com.demo.embaded.data.remote.NetworkService
import com.demo.embaded.di.module.ApplicationModule
import com.mindorks.bootcamp.demo.utils.NetworkHelper
import dagger.Component
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(myApplication: MyApplication)

    fun getDatabaseService(): DatabaseService

    fun getNetworkService(): NetworkService

    fun getNetworkHelper(): NetworkHelper

    fun getCompositeDisposable(): CompositeDisposable
}