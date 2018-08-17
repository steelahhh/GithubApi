package com.github.steelahhh.githubapplication.network

import com.github.steelahhh.githubapplication.Constants.BASE_URL
import com.github.steelahhh.githubapplication.model.UserProfile
import com.github.steelahhh.githubapplication.model.UserRepo
import io.reactivex.Single
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import java.util.concurrent.TimeUnit

interface RepositoryAPI {

  @GET("/users/{username}")
  fun getUser(@Path("username") userName: String): Single<UserProfile>

  @GET("/users/{username}/repos")
  fun getUserRepos(@Path("username") userName: String): Single<List<UserRepo>>

}

class RepositoryService {

  private var repositoryApi: RepositoryAPI? = null

  private val service: RepositoryAPI
    get() {
      if (repositoryApi == null) {
        repositoryApi = createService()
      }
      return repositoryApi!!
    }

  init {
    repositoryApi = createService()
  }

  private fun createService(): RepositoryAPI {
    val httpClient = OkHttpClient.Builder()
        .connectTimeout(3L, TimeUnit.SECONDS)
        .readTimeout(3L, TimeUnit.SECONDS)
        .build()

    val retrofit = Retrofit.Builder()
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(httpClient)
        .build()

    return retrofit.create(RepositoryAPI::class.java)
  }

  fun getUser(name: String) = service.getUser(name)

  fun getUserRepos(name: String) = service.getUserRepos(name)

}