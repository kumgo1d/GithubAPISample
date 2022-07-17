package com.kumgo1d.githubapisample.data.mapper

import com.kumgo1d.githubapisample.data.data.UserResponse
import com.kumgo1d.githubapisample.domain.data.User

fun mapperToUser(userResponse: UserResponse): User {
    return User(
        userID = userResponse.userID,
        nodeID = userResponse.nodeId,
        apiUrl = userResponse.apiUrl,
        userHtmlUrl = userResponse.userHtmlUrl,
        avatarImageUrl = userResponse.avatarImageUrl,
        followersUrl = userResponse.followersUrl,
        reposUrl = userResponse.reposUrl
    )
}