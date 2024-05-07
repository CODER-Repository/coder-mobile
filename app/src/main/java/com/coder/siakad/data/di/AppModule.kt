package com.coder.siakad.data.di

import android.content.Context
import com.coder.siakad.data.repository.auth.AuthRepositoryImpl
import com.coder.siakad.data.repository.dashboard.DashboardRepositoryImpl
import com.coder.siakad.data.repository.schedule.ScheduleRepositoryImpl
import com.coder.siakad.data.source.local.localPreferences.UserPreference
import com.coder.siakad.data.source.remote.network.retrofit.ApiService
import com.coder.siakad.domain.repository.AuthRepository
import com.coder.siakad.domain.repository.DashboardRepository
import com.coder.siakad.domain.repository.ScheduleRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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
//    @Singleton
//    @Provides
//    fun provideDashBoardRepository(@ApplicationContext context: Context): DashboardRepository{
//        return DashboardRepositoryImpl(context)
//    }

    @Singleton
    @Provides
    fun provideDashboardRepository(
        api: ApiService): DashboardRepository {
        return DashboardRepositoryImpl(api)
    }

    @Singleton
    @Provides
    fun provideScheduleRepository(
        api: ApiService): ScheduleRepository{
        return ScheduleRepositoryImpl(api)
    }
}