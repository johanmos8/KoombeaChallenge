package com.example.koombeaapp.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.koombeaapp.domain.models.UserDomain
import com.example.koombeaapp.domain.repositories.IUserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val iUserRepository: IUserRepository
) : ViewModel() {

    private val _userList = MutableStateFlow<List<UserDomain>>(emptyList())
    val userList: StateFlow<List<UserDomain>> = _userList

    init {
        Log.d("VM-Log","init")

        getAllUsers()
    }

    private fun getAllUsers() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                iUserRepository.getAllUsers().collect {
                    _userList.value = it
                    Log.d("VM-Log","value: $it")
                }
            } catch (e: Exception) {
                Log.d("VM-Log","ERROR: ${e.message}")

            }
        }
    }
}