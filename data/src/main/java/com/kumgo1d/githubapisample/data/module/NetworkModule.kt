package com.kumgo1d.githubapisample.data.module

import com.kumgo1d.githubapisample.data.api.GithubApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {
    @Singleton
    @Provides
    fun provideGithubApiService(): GithubApiService = GithubApiService.create()
}