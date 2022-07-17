package com.kumgo1d.githubapisample.data.module

import android.content.Context
import com.kumgo1d.githubapisample.data.db.GithubSampleDatabase
import com.kumgo1d.githubapisample.data.db.UserDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): GithubSampleDatabase {
        return GithubSampleDatabase.getInstance(context)
    }

    @Singleton
    @Provides
    fun provideUserDao(database: GithubSampleDatabase): UserDAO {
        return database.userDAO()
    }
}