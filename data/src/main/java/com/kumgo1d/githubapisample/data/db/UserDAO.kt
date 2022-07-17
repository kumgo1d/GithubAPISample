package com.kumgo1d.githubapisample.data.db

import androidx.room.*
import com.kumgo1d.githubapisample.data.entity.UserEntity

@Dao
interface UserDAO {
    @Query("select * from bookmark_user ORDER BY markedAt DESC")
    suspend fun getAllUsers(): MutableList<UserEntity>

    @Query("select * from bookmark_user WHERE login = :login LIMIT 1")
    suspend fun getUser(login: String): UserEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: UserEntity)

    @Delete
    suspend fun delete(item: UserEntity)
}