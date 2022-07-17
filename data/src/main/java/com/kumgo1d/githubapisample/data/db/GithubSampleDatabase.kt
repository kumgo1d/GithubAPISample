package com.kumgo1d.githubapisample.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.kumgo1d.githubapisample.data.entity.UserEntity

@Database(entities = [UserEntity::class], version = 1, exportSchema = false)
abstract class GithubSampleDatabase: RoomDatabase() {
    abstract fun userDAO(): UserDAO

    companion object {
        fun getInstance(context: Context): GithubSampleDatabase {
            return buildDatabase(context)
        }

        private fun buildDatabase(context: Context): GithubSampleDatabase {
            return Room.databaseBuilder(context, GithubSampleDatabase::class.java, "github_sample_database")
                .build()
        }
    }
}