package com.example.examplemvp.http

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class ApiModule {
    val BASE_URL = "https://api.twitch.tv/"

    @Provides
    fun provideClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder().addInterceptor(interceptor).build()
    }

     @Provides
     fun provideRetrofit(baseURL: String, client: OkHttpClient): Retrofit {
         return Retrofit.Builder()
             .baseUrl(baseURL)
             .client(client)
             .addConverterFactory(GsonConverterFactory.create())
             .build()
     }

    @Provides
    fun provideApiService(): TwitchAPI {
        return provideRetrofit(BASE_URL, provideClient()).create(TwitchAPI::class.java)
    }
}