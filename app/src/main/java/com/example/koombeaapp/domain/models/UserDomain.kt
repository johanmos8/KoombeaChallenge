package com.example.koombeaapp.domain.models

data class UserDomain(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val userName: String,
    val email: String,
    val gender: String,
    val pictureUrl: String,
    val phone: String,
    val birthday: String,
    val twitterHandle: String

)
