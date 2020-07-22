package com.example.task2.network

import com.bumptech.glide.Glide.init
//import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import io.reactivex.rxjava3.plugins.RxJavaPlugins
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.nio.file.attribute.AclEntry
import java.nio.file.attribute.BasicFileAttributeView
import java.util.concurrent.TimeUnit

class ApiClient {
    companion object {
        val instance: ApiClient by lazy { ApiClient() }
        private const val BASE_URL = "https://free-nba.p.rapidapi.com/"
        private const val TIMEOUT: Long = 30
        private const val API_KEY = "b2ac924154mshe70df74959d5a4ap16a82ajsn32f81052a10f"
    }

    val mainApi: IMainApi

    init {
        mainApi = createRetrofit(createOkHttpClient()).create(IMainApi::class.java)
    }

    fun createRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()

    }
    fun createOkHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
        builder.apply {
            readTimeout(TIMEOUT, TimeUnit.SECONDS)
            connectTimeout(TIMEOUT, TimeUnit.SECONDS)
            addInterceptor {
                var request = it.request()
                request = request.newBuilder()
                    .addHeader("x-rapidapi-key", API_KEY)
                    .build()
                it.proceed(
                    request
                )
            }
            return builder.build()
        }
    }
}