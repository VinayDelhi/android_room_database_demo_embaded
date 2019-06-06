package com.demo.embaded.ui.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.demo.embaded.data.local.DatabaseService
import com.demo.embaded.data.local.entity.Address
import com.demo.embaded.data.local.entity.User
import com.demo.embaded.data.remote.NetworkService
import com.demo.embaded.di.ActivityScope
import com.mindorks.bootcamp.demo.utils.NetworkHelper
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


@ActivityScope
class MainViewModel @Inject constructor(
         private val compositeDisposable: CompositeDisposable,
         private val databaseService: DatabaseService,
         private val networkService: NetworkService,
         private val networkHelper: NetworkHelper) {

    companion object{

        const val TAG = "MainViewModel"
    }

     private var users: List<User> = emptyList()
     val allUsers = MutableLiveData<List<User>>()

    init {

        compositeDisposable.add(

                  databaseService.getUserDao()
                      .count()
                      .flatMap {

                          if(it == 0){

                              databaseService.getUserDao()
                                  .insertMany(
                                      User(name = "Vinay", companyName = "Umbrella",address = Address(city = "Noida", country = "India", code = 1)),
                                      User(name = "Satya", companyName = "Nagarro",address = Address(city = "Gurgaon", country = "UK", code = 2)),
                                      User(name = "Rohit", companyName = "Tdsys",address = Address(city = "Ghaziabad", country = "Swedan", code = 3)),
                                      User(name = "Ajaz", companyName = "Amdocs",address = Address(city = "Faridabad", country = "Newzeland", code = 4)),
                                      User(name = "Sunil", companyName = "Amazon",address = Address(city = "Merrut", country = "Astralia", code = 5)),
                                      User(name = "Shiv", companyName = "Google",address = Address(city = "Lucknow", country = "England", code = 6))

                                  )

                          }else{
                              Single.just(0)
                          }

                      }
                      .subscribeOn(Schedulers.io())
                      .subscribe(
                          {

                              Log.d(TAG, "User present in db $it")
                          },

                          {

                              Log.d(TAG, "Error occures ${it.toString()}")

                          }

                      )

        )

    }


    fun onDestroy(){

        compositeDisposable.dispose()
    }


    fun getAllUser(){

        compositeDisposable.add(

            databaseService.getUserDao()
                .getAllUser()
                .subscribeOn(Schedulers.io())
                .subscribe(

                    {

                        users = it

                        Log.d(TAG, "Get All User ${it.toString()}")

                        allUsers.postValue(it)
                    },

                    {

                        Log.d(TAG, "Error occures ${it.toString()}")
                    }

                )
        )
    }


    fun deleteUser(){

        if(users.isNotEmpty())
             compositeDisposable.add(
                   databaseService.getUserDao()
                    .deleteUser(users[0])
                    .flatMap {

                        databaseService.getUserDao().getAllUser()
                    }
                    .subscribeOn(Schedulers.io())
                    .subscribe(
                        {

                            users = it

                            allUsers.postValue(it)
                        },

                        {

                            Log.d(TAG, "Error Occured ${it.toString()}")
                        }
                    )
             )
      }


}