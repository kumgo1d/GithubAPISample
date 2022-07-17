package com.kumgo1d.githubapisample.data.repository.local

import com.kumgo1d.githubapisample.data.db.UserDAO
import javax.inject.Inject

interface GithubApiLocalDataSource {
}

class GithubApiLocalDataSourceImpl @Inject constructor(
    private val userDAO: UserDAO
): GithubApiLocalDataSource {

}