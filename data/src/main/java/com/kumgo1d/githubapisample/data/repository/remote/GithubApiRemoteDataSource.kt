package com.kumgo1d.githubapisample.data.repository.remote

import com.kumgo1d.githubapisample.data.api.GithubApiService
import com.kumgo1d.githubapisample.data.mapper.mapperToUser
import com.kumgo1d.githubapisample.domain.data.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
interface GithubApiRemoteDataSource {
    suspend fun getUsers(since: Int, page: Int): List<User>
}

class GithubApiRemoteDataSourceImpl @Inject constructor (
    private val githubApiService: GithubApiService
): GithubApiRemoteDataSource {
    private val ioDispatcher = Dispatchers.IO

    override suspend fun getUsers(since: Int, page: Int): List<User> = withContext(ioDispatcher) {
        return@withContext githubApiService.getUsers(since, page).map {
            mapperToUser(it)
        }
    }
}