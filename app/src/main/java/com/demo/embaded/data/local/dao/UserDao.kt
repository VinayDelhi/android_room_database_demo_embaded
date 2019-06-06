package com.demo.embaded.data.local.dao

import android.util.Log
import androidx.room.*
import com.demo.embaded.data.local.entity.User
import io.reactivex.Single

@Dao
interface UserDao {

    @Insert
    fun insertUser(user: User): Single<Long>

    @Update
    fun updateUser(user: User): Single<Int>

    @Delete
    fun deleteUser(user: User): Single<Int>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMany(vararg user: User):Single<List<Long>>

    @Query("SELECT count(*) FROM users")
    fun count(): Single<Int>

    @Query("SELECT * FROM users")
    fun getAllUser(): Single<List<User>>




}