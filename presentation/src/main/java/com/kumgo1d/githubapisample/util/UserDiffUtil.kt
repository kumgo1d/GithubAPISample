package com.kumgo1d.githubapisample.util

import androidx.recyclerview.widget.DiffUtil
import com.kumgo1d.githubapisample.domain.data.User

object UserDiffUtil: DiffUtil.ItemCallback<User>() {
    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem == newItem
    }
}