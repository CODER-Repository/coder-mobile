package com.coder.siakad.data.di

import com.coder.siakad.data.repository.auth.AuthRepository
import com.coder.siakad.data.source.remote.network.retrofit.ApiService
import com.coder.siakad.data.util.Constants.BASE_URL
import com.coder.siakad.domain.repository.SiakadRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideSiakadRepository(
        api: ApiService
    ): SiakadRepository {
        return AuthRepository(api)
    }
}