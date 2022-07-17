package com.kumgo1d.githubapisample.data.data

import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("node_id") val nodeId: String,
    @SerializedName("login") val userID: String,
    @SerializedName("url") val apiUrl: String,
    @SerializedName("html_url") val userHtmlUrl: String,
    @SerializedName("followers_url") val followersUrl: String,
    @SerializedName("avatar_url") val avatarImageUrl: String,
    @SerializedName("repos_url") val reposUrl: String
) {
    override fun equals(other: Any?): Boolean {
        return nodeId == (other as UserResponse).nodeId
    }
}
