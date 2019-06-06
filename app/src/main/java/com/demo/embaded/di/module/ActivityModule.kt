package com.demo.embaded.di.module

import android.app.Activity
import android.content.Context
import com.demo.embaded.di.ActivityContext
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private val activity: Activity) {

    @Provides
    @ActivityContext
    fun provideContext(): Context = activity
}