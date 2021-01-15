package com.example.msappkotlin.di

import com.example.msappkotlin.network.ApiService
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.*

val networkModule = module {

    single { provideDefaultOkHttpClient() }
    single { provideRetrofit(get())}
    single { provideApiService(get()) }

}

private const val BASE_SERVER_URL: String = "https://api.androidhive.info/"

fun provideDefaultOkHttpClient(): OkHttpClient{
    val httpClient = OkHttpClient.Builder()
    return httpClient.build()
}

fun provideRetrofit(client: OkHttpClient):Retrofit{
    val moshi = Moshi.Builder()
        .add(Date::class.java, Rfc3339DateJsonAdapter().nullSafe())
        .build()

    return Retrofit.Builder()
        .baseUrl(BASE_SERVER_URL)
        .client(client)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
}

fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)