package com.kumgo1d.githubapisample.data.module

import com.kumgo1d.githubapisample.data.db.UserDAO
import com.kumgo1d.githubapisample.data.repository.local.GithubApiLocalDataSource
import com.kumgo1d.githubapisample.data.repository.local.GithubApiLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class LocalDataModule {
    @Singleton
    @Provides
    fun provideLocalDataSource(userDAO: UserDAO): GithubApiLocalDataSource {
        return GithubApiLocalDataSourceImpl(userDAO)
    }
}