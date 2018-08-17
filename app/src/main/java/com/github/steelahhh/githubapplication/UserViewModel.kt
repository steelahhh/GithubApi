package com.github.steelahhh.githubapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.steelahhh.githubapplication.model.UserProfile
import com.github.steelahhh.githubapplication.model.UserRepo
import com.github.steelahhh.githubapplication.network.DataState
import com.github.steelahhh.githubapplication.network.RepositoryService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.schedulers.Schedulers

class UserViewModel : ViewModel() {
  // normally this would be constructor injected
  private val service = RepositoryService()

  private val disposables = CompositeDisposable()

  val user = MutableLiveData<DataState<UserProfile>>()
  val userRepos = MutableLiveData<DataState<List<UserRepo>>>()

  fun fetchUser(name: String) {
    disposables += service.getUser(name)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({
          user.postValue(DataState.SUCCESS(it))
        }, {
          user.postValue(DataState.FAILURE(it))
        })
  }

  fun fetchUserRepos(name: String) {
    disposables += service.getUserRepos(name)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({
          userRepos.postValue(DataState.SUCCESS(it))
        }, {
          userRepos.postValue(DataState.FAILURE(it))
        })
  }

  override fun onCleared() {
    super.onCleared()
    disposables.clear()
  }
}