package com.vnedomovnyi.moviecompose.di

import com.google.gson.Gson
import com.vnedomovnyi.moviecompose.BASE_URL
import com.vnedomovnyi.moviecompose.network.ApiKeyInterceptor
import com.vnedomovnyi.moviecompose.network.MovieService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Provides
    fun provideOkHttpClient() =
        OkHttpClient.Builder()
            .addInterceptor(ApiKeyInterceptor())
            .build()

    @Provides
    fun provideGson() = Gson()

    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, gson: Gson) =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

    @Provides
    fun provideMovieService(retrofit: Retrofit) = retrofit.create(MovieService::class.java)

}