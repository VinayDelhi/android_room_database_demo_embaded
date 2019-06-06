package com.demo.embaded.ui.home

import com.demo.embaded.data.local.DatabaseService
import com.demo.embaded.data.remote.NetworkService
import com.demo.embaded.di.FragmentScope
import com.mindorks.bootcamp.demo.utils.NetworkHelper
import javax.inject.Inject

@FragmentScope
class HomeViewModel @Inject constructor(
                private val databaseService: DatabaseService,
                private val networkService: NetworkService,
                private val networkHelper: NetworkHelper)

{
    val someData: String

    get() = "${networkService.someData}"
}