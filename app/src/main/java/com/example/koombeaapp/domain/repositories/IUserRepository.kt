package com.example.koombeaapp.domain.repositories

import com.example.koombeaapp.domain.models.UserDomain
import kotlinx.coroutines.flow.Flow


interface IUserRepository {
    suspend fun getAllUsers(): Flow<List<UserDomain>>
}