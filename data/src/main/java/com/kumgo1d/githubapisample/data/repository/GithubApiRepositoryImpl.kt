package com.kumgo1d.githubapisample.data.repository

import com.kumgo1d.githubapisample.data.repository.local.GithubApiLocalDataSource
import com.kumgo1d.githubapisample.data.repository.remote.GithubApiRemoteDataSource
import com.kumgo1d.githubapisample.domain.data.User
import com.kumgo1d.githubapisample.domain.repository.GithubApiRepository
import javax.inject.Inject
import javax.inject.Singleton

class GithubApiRepositoryImpl @Inject constructor (
    private val apiRemoteDataSource: GithubApiRemoteDataSource,
    private val apiLocalDataSource: GithubApiLocalDataSource
): GithubApiRepository {
    override suspend fun getUsers(since: Int, page: Int): List<User> {
        return apiRemoteDataSource.getUsers(since, page)
    }
}