package com.github.steelahhh.githubapplication.network

sealed class DataState<T> {
  data class SUCCESS<T>(var data: T) : DataState<T>()
  data class FAILURE<T>(var exception: Throwable) : DataState<T>()
}