package com.demo.embaded.data.remote

import android.content.Context
import com.demo.embaded.di.ApplicationContext
import com.demo.embaded.di.NetworkInfo
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkService @Inject constructor(   // context must be application context
    @ApplicationContext private val context: Context,
    @NetworkInfo private val apiKey:String)

{
    val someData:String
    get() = "$apiKey"
}