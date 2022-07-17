package com.kumgo1d.githubapisample.domain.usecase

import com.kumgo1d.githubapisample.domain.data.User
import com.kumgo1d.githubapisample.domain.repository.GithubApiRepository
import javax.inject.Inject

class GetGithubApiUsersUseCase @Inject constructor(
    private val repository: GithubApiRepository
) {
    suspend fun excute(since: Int, page: Int): List<User> {
        return repository.getUsers(since, page)
    }
}