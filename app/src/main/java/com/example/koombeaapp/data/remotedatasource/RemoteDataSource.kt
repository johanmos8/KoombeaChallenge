package com.example.koombeaapp.data.remotedatasource

import com.example.koombeaapp.data.apiServices.ApiService
import com.example.koombeaapp.data.mappers.UserDataToUserDomainMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val userDataToUserDomainMapper: UserDataToUserDomainMapper,
    private val apiService: ApiService

) : IRemoteDS {


    override fun getAllUsers() = flow {
        emit(userDataToUserDomainMapper.invoke(apiService.getUsers()))
    }.flowOn(Dispatchers.IO)

}