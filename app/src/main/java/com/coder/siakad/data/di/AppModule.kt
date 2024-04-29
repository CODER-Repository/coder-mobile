package com.coder.siakad.data.di

import com.coder.siakad.data.repository.auth.AuthRepositoryImpl
import com.coder.siakad.data.source.local.localPreferences.UserPreference
import com.coder.siakad.data.source.remote.network.retrofit.ApiService
import com.coder.siakad.domain.repository.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideSiakadRepository(
        api: ApiService,
//        pref: UserPreference
    ): AuthRepository {
        return AuthRepositoryImpl(api)
    }
}