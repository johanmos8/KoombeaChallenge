package com.example.koombeaapp.data.remotedatasource

import com.example.koombeaapp.domain.models.UserDomain
import kotlinx.coroutines.flow.Flow

interface IRemoteDS {
    fun getAllUsers(): Flow<List<UserDomain>>
}