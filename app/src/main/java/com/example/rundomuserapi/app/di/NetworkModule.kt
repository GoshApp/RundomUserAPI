package com.example.rundomuserapi.app.di

import com.example.rundomuserapi.BuildConfig.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.kodein.di.Kodein.Module
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private const val MODULE_NAME = "Network Module"

val networkModule = Module(MODULE_NAME, false) {
  bind<OkHttpClient>() with singleton { getMockOkHttpClient() }
  bind<Retrofit>() with singleton { getMockRetrofit(instance()) }
}

private fun getMockOkHttpClient(): OkHttpClient {
  val httpBuilder = OkHttpClient.Builder()
  httpBuilder.readTimeout(90, TimeUnit.SECONDS).connectTimeout(90, TimeUnit.SECONDS).build()

  if (true) {
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
    httpBuilder.interceptors()
        .add(httpLoggingInterceptor)
  }
  return httpBuilder.build()
}

private fun getMockRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
    .client(okHttpClient)
    .build()

