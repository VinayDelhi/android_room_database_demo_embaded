package com.demo.embaded.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
import com.demo.embaded.data.local.dao.UserDao
import com.demo.embaded.data.local.entity.User
import com.demo.embaded.di.ApplicationContext
import com.demo.embaded.di.DatabaseInfo
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
@Database(entities = [
                     User::class
                     ],
                     version = 1,
                     exportSchema = false
                     )
abstract class DatabaseService: RoomDatabase(){

    abstract fun getUserDao(): UserDao

}
