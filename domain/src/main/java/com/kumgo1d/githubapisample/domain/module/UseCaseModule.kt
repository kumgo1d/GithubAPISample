package com.kumgo1d.githubapisample.domain.module

import com.kumgo1d.githubapisample.domain.repository.GithubApiRepository
import com.kumgo1d.githubapisample.domain.usecase.GetGithubApiUsersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class UseCaseModule {
    @Singleton
    @Provides
    fun provideGetGithubApiUsersUseCase(repository: GithubApiRepository): GetGithubApiUsersUseCase {
        return GetGithubApiUsersUseCase(repository)
    }
}