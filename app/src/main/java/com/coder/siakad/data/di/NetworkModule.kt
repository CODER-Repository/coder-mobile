package com.coder.siakad.data.di

//import com.coder.siakad.BuildConfig
import android.app.Application
import android.content.Context
import android.util.Log
import com.coder.siakad.BuildConfig
import com.coder.siakad.data.source.local.localPreferences.UserPreference
import com.coder.siakad.data.source.local.localPreferences.dataUser
import com.coder.siakad.data.source.remote.network.retrofit.ApiService
import com.coder.siakad.data.util.Constants.BASE_URL
import com.coder.siakad.data.util.Constants.DEBUG
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Singleton
    @Provides
    fun provideOkHttpClient(application: Application): OkHttpClient {
        val context = application.applicationContext
        return OkHttpClient.Builder()
            .addInterceptor(
                if (BuildConfig.DEBUG) {
                    HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
                } else {
                    HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.NONE)
                }
            )
            .addInterceptor(provideAuthInterceptor(context = context))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()
    }

    @Singleton
    @Provides
    fun provideApiService(client: OkHttpClient): ApiService {
        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
        return retrofit.create(ApiService::class.java)
    }

    //get token
    @Singleton
    @Provides
    fun provideAuthInterceptor(context: Context): Interceptor {
        return Interceptor {chain ->
            val req = chain.request()
//            val token = getTokenFromContext(context)
            val token = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiI4NmQ5OGE2Yy1kNTViLTQyMWUtOTA3NC0xZWI0OTFjZGMyN2UiLCJlbWFpbCI6ImpvaG5kb2VAc3R1ZGVudC5hYy5pZCIsInJvbGUiOiJTdHVkZW50Iiwicm9sZUlkIjoiU1REIiwiaWF0IjoxNzA5NDQzODYzLCJleHAiOjE3MDk0NDc0NjN9.F4qmKxjBLDD1agvfgoEZgWB6WteKvQ-6_qDbRgbaJ6I"
                val requestHeaders = req.newBuilder()
                    .addHeader("Authorization", "Bearer $token")
                    .addHeader("Content-type", "application/json")
                    .build()
            chain.proceed(requestHeaders)
        }
    }

    @Singleton
    @Provides
    fun getTokenFromContext(context: Context): String {
        val pref = UserPreference(context.dataUser)
        val user = runBlocking {
            pref.getUser().first()
        }
        Log.e(user.token, "Not Found")
        return user.token ?: ""
    }
}

