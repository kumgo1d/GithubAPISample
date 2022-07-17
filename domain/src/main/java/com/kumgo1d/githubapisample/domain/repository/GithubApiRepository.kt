package com.kumgo1d.githubapisample.domain.repository

import com.kumgo1d.githubapisample.domain.data.User
import javax.inject.Singleton

@Singleton
interface GithubApiRepository {
    suspend fun getUsers(since: Int, page: Int): List<User>
}