package com.coder.siakad.data.di

//import com.coder.siakad.BuildConfig
import android.content.Context
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
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(
//                if (BuildConfig.DEBUG) {
                if (DEBUG) {
                    HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
                } else {
                    HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.NONE)
                }
            )
//            .addInterceptor(provideAuthInterceptor())
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()
    }

    @Singleton
    @Provides
    fun provideApiService(client: OkHttpClient): ApiService {
        val retrofit = Retrofit.Builder()
//            .baseUrl(BuildConfig.BASE_URL)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
        return retrofit.create(ApiService::class.java)
    }

//    @Singleton
//    @Provides
//    fun provideAuthInterceptor() {
//        val authInterceptor = Interceptor {chain ->
//            val req = chain.request()
//            val token = getTokenFromContext(context = )
//                val requestHeaders = req.newBuilder()
//                    .addHeader("Authorization", "Bearer $token")
//                    .addHeader("Content-type", "application/json")
//                    .build()
//            chain.proceed(requestHeaders)
//        }
//    }

    @Singleton
    @Provides
    fun getTokenFromContext(context: Context): String {
        val pref = UserPreference(context.dataUser)
        val user = runBlocking {
            pref.getUser().first()
        }
        return user.token ?: ""
    }
}

