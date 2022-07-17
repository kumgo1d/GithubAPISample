package com.kumgo1d.githubapisample.data.module

import com.kumgo1d.githubapisample.data.repository.GithubApiRepositoryImpl
import com.kumgo1d.githubapisample.data.repository.local.GithubApiLocalDataSource
import com.kumgo1d.githubapisample.data.repository.remote.GithubApiRemoteDataSource
import com.kumgo1d.githubapisample.domain.repository.GithubApiRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RepositoryModule {
    @Singleton
    @Provides
    fun provideGithubApiRepository(
        githubApiRemoteDataSource: GithubApiRemoteDataSource,
        githubApiLocalDataSource: GithubApiLocalDataSource
    ): GithubApiRepository {
        return GithubApiRepositoryImpl(githubApiRemoteDataSource, githubApiLocalDataSource)
    }
}