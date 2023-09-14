package com.example.koombeaapp.data.mappers

import com.example.koombeaapp.data.entities.UserDTO
import com.example.koombeaapp.domain.models.UserDomain
import javax.inject.Inject

class UserDataToUserDomainMapper @Inject constructor() {
    operator fun invoke(userList: List<UserDTO>): List<UserDomain> {
        with(userList) {
            return userList.map {
                UserDomain(
                    id = it.id,
                    userName = it.username,
                    firstName = it.firstName,
                    lastName= it.lastName,
                    email = it.email,
                    gender = it.gender,
                    pictureUrl = it.pictureURL,
                    phone = it.phone,
                    birthday = it.birthday,
                    twitterHandle = it.twitterHandle
                )
            }
        }

    }
}