package com.example.loginauthsample.di

import com.example.loginauthsample.data.remote.DummyApi
import com.example.loginauthsample.repository.DummyRepository
import com.example.loginauthsample.utils.Constants.API_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule{

    @Singleton
    @Provides
    fun  provideDummyRepository(
        api: DummyApi
    ) = DummyRepository(api)

    @Singleton
    @Provides
    fun provideDummyApi() : DummyApi{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(API_URL)
            .build()
            .create(DummyApi::class.java)
    }
}