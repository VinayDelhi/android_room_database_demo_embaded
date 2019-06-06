package com.demo.embaded.di.module

import android.content.Context
import androidx.fragment.app.Fragment
import com.demo.embaded.di.ActivityContext
import dagger.Module
import dagger.Provides

@Module
class FragmentModule(private val fragment: Fragment) {

    @Provides
    @ActivityContext
    fun provideContext(): Context = fragment.context!!
}