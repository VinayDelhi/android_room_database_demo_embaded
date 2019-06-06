package com.demo.embaded.di.component

import com.demo.embaded.di.ActivityScope
import com.demo.embaded.di.module.ActivityModule
import com.demo.embaded.ui.main.MainActivity
import dagger.Component

@ActivityScope
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {

    fun inject(mainActivity: MainActivity)
}