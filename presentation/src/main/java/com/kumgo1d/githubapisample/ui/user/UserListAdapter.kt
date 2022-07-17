package com.kumgo1d.githubapisample.ui.user

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kumgo1d.githubapisample.databinding.ItemUserBinding
import com.kumgo1d.githubapisample.domain.data.User
import com.kumgo1d.githubapisample.util.UserDiffUtil

class UserListAdapter: ListAdapter<User, UserListAdapter.ViewHolder>(UserDiffUtil) {
    inner class ViewHolder(private val binding: ItemUserBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User) {
            binding.userId.text = user.userID
            Glide.with(binding.root)
                .load(user.avatarImageUrl)
                .into(binding.userAvatarImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemUserBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }
}