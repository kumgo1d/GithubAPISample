package com.kumgo1d.githubapisample.viewModel.user

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kumgo1d.githubapisample.domain.data.User
import com.kumgo1d.githubapisample.domain.usecase.GetGithubApiUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val getGithubApiUsersUseCase: GetGithubApiUsersUseCase
): ViewModel() {
    private val _users = MutableLiveData<List<User>>()
    val users: LiveData<List<User>> = _users

    fun getUsers(since: Int, page: Int) {
        viewModelScope.launch {
            _users.postValue(getGithubApiUsersUseCase.excute(since, page))
        }
    }
}