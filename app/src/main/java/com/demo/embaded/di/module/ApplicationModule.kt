package com.demo.embaded.di.module

import android.content.Context
import androidx.room.Room
import com.demo.embaded.MyApplication
import com.demo.embaded.data.local.DatabaseService
import com.demo.embaded.di.ApplicationContext
import com.demo.embaded.di.DatabaseInfo
import com.demo.embaded.di.NetworkInfo
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: MyApplication) {

    @Provides
    @ApplicationContext
    fun provideContext(): Context = application

    @Provides
    @DatabaseInfo
    fun provideDatabaseName(): String{

        return "xyz"
    }

    @Provides
    @DatabaseInfo
    fun provideDatabaseVersion(): Int{

        return 1
    }


    @Provides
    @NetworkInfo
    fun provideApiKey(): String{

        return "abc"
    }

    @Provides
    @Singleton
    fun provideDatabaseServie(): DatabaseService = Room.databaseBuilder(
                                                       application,
                                                        DatabaseService::class.java,
                                                        "bootcamp-database-project-db"
                                                        ).build()
    @Provides
    fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()
}