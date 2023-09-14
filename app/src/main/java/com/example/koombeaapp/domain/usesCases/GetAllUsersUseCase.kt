package com.example.koombeaapp.domain.usesCases

import com.example.koombeaapp.domain.repositories.IUserRepository
import javax.inject.Inject

class GetAllUsersUseCase @Inject constructor(
    private val iUserRepository: IUserRepository
) {
    suspend operator fun invoke() = iUserRepository.getAllUsers()
}