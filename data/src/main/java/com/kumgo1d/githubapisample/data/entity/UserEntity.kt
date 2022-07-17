package com.kumgo1d.githubapisample.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "bookmark_user", primaryKeys = ["nodeId"])
data class UserEntity(
    @ColumnInfo var marked: Boolean,
    @ColumnInfo var markedAt: Long = System.currentTimeMillis(),
    @ColumnInfo val nodeId: String,
    @ColumnInfo val avatarImageUrl: String,
    @ColumnInfo val starredUrl: String,
    @ColumnInfo val reposUrl: String,
    @ColumnInfo val login: String,
    @ColumnInfo val name: String?,
    @ColumnInfo val location: String?,
    @ColumnInfo val followers: Int,
    @ColumnInfo val following: Int,
) {
    override fun equals(other: Any?): Boolean {
        return nodeId == (other as UserEntity).nodeId
    }
}
