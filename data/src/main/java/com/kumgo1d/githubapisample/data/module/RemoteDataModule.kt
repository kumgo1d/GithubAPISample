package com.kumgo1d.githubapisample.data.module

import com.kumgo1d.githubapisample.data.api.GithubApiService
import com.kumgo1d.githubapisample.data.repository.remote.GithubApiRemoteDataSource
import com.kumgo1d.githubapisample.data.repository.remote.GithubApiRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RemoteDataModule {
    @Singleton
    @Provides
    fun provideRemoteDataSource(githubApiService: GithubApiService): GithubApiRemoteDataSource {
        return GithubApiRemoteDataSourceImpl(githubApiService)
    }
}