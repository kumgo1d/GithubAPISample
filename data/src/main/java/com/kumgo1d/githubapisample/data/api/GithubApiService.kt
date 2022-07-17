package com.kumgo1d.githubapisample.data.api

import com.kumgo1d.githubapisample.data.data.UserResponse
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface GithubApiService {
    @GET("users")
    suspend fun getUsers(
        @Query("since") since: Int = 0,
        @Query("per_page") page: Int = 20
    ): List<UserResponse>

    @GET("users/{username}")
    suspend fun getUser(
        @Path("username") username: String
    ): UserResponse

    @PUT("user/following/{username}")
    suspend fun followUser(
        @Path("username") username: String
    ): String

    @DELETE("user/following/{username}")
    suspend fun unfollowUser(
        @Path("username") username: String
    ): String

    companion object {
        fun create(): GithubApiService {
            val client = OkHttpClient.Builder().build()

            return Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(GithubApiService::class.java)
        }
    }
}