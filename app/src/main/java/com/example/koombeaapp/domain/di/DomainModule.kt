package com.example.koombeaapp.domain.di

import com.example.koombeaapp.domain.repositories.IUserRepository
import com.example.koombeaapp.domain.usesCases.GetAllUsersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    @Singleton
    fun provideGetAllUserCase(
        iUserRepository: IUserRepository
    ): GetAllUsersUseCase {
        return GetAllUsersUseCase(
            iUserRepository
        )
    }
}
