package com.kumgo1d.githubapisample.ui.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.kumgo1d.githubapisample.databinding.FragmentUserListBinding
import com.kumgo1d.githubapisample.viewModel.user.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserListFragment : Fragment() {
    private val viewModel by viewModels<UserViewModel>()

    private lateinit var binding: FragmentUserListBinding
    private lateinit var adapter: UserListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUserListBinding.inflate(inflater, container, false)
        setUserRecyclerViewAdapter()
        return binding.root
    }

    private fun setUserRecyclerViewAdapter() {
        adapter = UserListAdapter()
        binding.userRecyclerView.adapter = adapter
        viewModel.getUsers(1, 20)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeUsers()
    }

    private fun observeUsers() {
        viewModel.users.observe(viewLifecycleOwner) { users ->
            adapter.submitList(users)
        }
    }
}