package com.demo.embaded.di.component

import com.demo.embaded.di.FragmentScope
import com.demo.embaded.di.module.FragmentModule
import com.demo.embaded.ui.home.HomeFragment
import dagger.Component

@FragmentScope
@Component(dependencies = [ApplicationComponent::class], modules = [FragmentModule::class])
interface FragmentComponent {

    fun inject(homeFragment: HomeFragment)
}