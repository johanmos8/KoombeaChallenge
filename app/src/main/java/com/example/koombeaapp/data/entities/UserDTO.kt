package com.example.koombeaapp.data.entities

import com.squareup.moshi.Json

data class UserDTO(
    @field:Json(name = "id") var id: Int,
    @field:Json(name = "firstName") var firstName: String,
    @field:Json(name = "lastName") var lastName: String,
    @field:Json(name = "userName") var username: String,
    @field:Json(name = "email") var email: String,
    @field:Json(name = "gender") var gender: String,
    @field:Json(name = "pictureUrl") var pictureURL: String,
    @field:Json(name = "phone") var phone: String,
    @field:Json(name = "birthday") var birthday: String,
    @field:Json(name = "twitterHandle") var twitterHandle: String

)
