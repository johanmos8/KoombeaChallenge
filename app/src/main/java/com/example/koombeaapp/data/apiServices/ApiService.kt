package com.example.koombeaapp.data.apiServices

import com.example.koombeaapp.data.entities.UserDTO
import retrofit2.http.GET


interface ApiService {

    @GET("/users")
    suspend fun getUsers(): List<UserDTO>
}