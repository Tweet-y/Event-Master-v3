package com.example.eventmaster.di

import com.example.eventmaster.data.network.AuthApiService
import com.example.eventmaster.data.network.AuthInterceptor
import com.example.eventmaster.data.network.CategoriaApiService
import com.example.eventmaster.data.network.EventoApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val BASE_URL = "http://10.0.2.2:8000/api/"

    @Provides
    @Singleton
    fun provideOkHttpClient(authInterceptor: AuthInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(authInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideAuthApiService(retrofit: Retrofit): AuthApiService =
        retrofit.create(AuthApiService::class.java)

    @Provides
    @Singleton
    fun provideCategoriaApiService(retrofit: Retrofit): CategoriaApiService =
        retrofit.create(CategoriaApiService::class.java)

    @Provides
    @Singleton
    fun provideEventoApiService(retrofit: Retrofit): EventoApiService =
        retrofit.create(EventoApiService::class.java)
}
