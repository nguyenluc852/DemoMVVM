package com.s.demomvvm.di.module

import android.app.Application
import android.content.Context
import com.s.demomvvm.BuildConfig
import com.s.demomvvm.network.api.ApiHelper
import com.s.demomvvm.network.api.ApiHelperImpl
import com.s.demomvvm.network.api.ApiService
import com.s.demomvvm.utils.AppConstant
import com.s.demomvvm.utils.AppPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideBaseUrl() = AppConstant.BASE_URL
    @Provides
    @Singleton
    internal fun provideContext(application: Application): Context {
        return application
    }


    @Provides
    @Singleton
    internal fun provideAppPreferenece(context: Context): AppPreferences {
        return AppPreferences(context)
    }



    @Provides
    @Singleton
    fun provideOkHttpClient() = if (BuildConfig.DEBUG) {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    } else OkHttpClient
        .Builder()
        .build()


    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient, BASE_URL: String): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit) = retrofit.create(ApiService::class.java)

    @Provides
    @Singleton
    fun provideApiHelper(apiHelper: ApiHelperImpl): ApiHelper = apiHelper
}