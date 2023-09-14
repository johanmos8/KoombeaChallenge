package com.example.koombeaapp.data.di

import com.example.koombeaapp.data.apiServices.ApiService
import com.example.koombeaapp.data.mappers.UserDataToUserDomainMapper
import com.example.koombeaapp.data.remotedatasource.IRemoteDS
import com.example.koombeaapp.data.remotedatasource.RemoteDataSource
import com.example.koombeaapp.data.repositories.UserRepository
import com.example.koombeaapp.domain.repositories.IUserRepository
import com.squareup.picasso.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Singleton
    @Provides
    fun provideOkHttpClient() = if (BuildConfig.DEBUG) {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS)
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        val requestInterceptor = Interceptor { chain ->
            val url = chain.request()
                .url
                .newBuilder()

                .build()

            val request = chain.request()
                .newBuilder()
                .url(url)
                .build()
            return@Interceptor chain.proceed(request)
        }

        OkHttpClient
            .Builder()
            .addInterceptor(requestInterceptor)
            .addInterceptor(loggingInterceptor)
            .build()
    } else {
        OkHttpClient
            .Builder()
            .build()
    }
    @Provides
    @Singleton
    fun provideRetrofit(
        client: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://jserver-api.herokuapp.com") // Reemplaza con la URL de tu servicio web
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }
    @Provides
    @Singleton
    fun provideRemoteDataSource(
        userDataToUserDomainMapper: UserDataToUserDomainMapper,
        apiService: ApiService
    ): IRemoteDS {
        return RemoteDataSource(userDataToUserDomainMapper, apiService)
    }
    @Singleton
    @Provides
    fun provideIUserRepository(
        iRemoteDS: IRemoteDS,

    ): IUserRepository {
        return UserRepository(
            iRemoteDS
        )
    }
}