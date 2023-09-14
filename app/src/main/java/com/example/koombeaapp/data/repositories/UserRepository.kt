package com.example.koombeaapp.data.repositories

import com.example.koombeaapp.data.mappers.UserDataToUserDomainMapper
import com.example.koombeaapp.data.remotedatasource.IRemoteDS
import com.example.koombeaapp.domain.models.UserDomain
import com.example.koombeaapp.domain.repositories.IUserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val iRemoteDS: IRemoteDS,

): IUserRepository {
    override suspend fun getAllUsers(): Flow<List<UserDomain>> {
        return iRemoteDS.getAllUsers()
    }
}