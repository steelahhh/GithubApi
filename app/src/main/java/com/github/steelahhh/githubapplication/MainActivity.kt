package com.github.steelahhh.githubapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.github.steelahhh.githubapplication.network.DataState.FAILURE
import com.github.steelahhh.githubapplication.network.DataState.SUCCESS

class MainActivity : AppCompatActivity() {

  private lateinit var vm: UserViewModel

  private var name = "jakewharton"

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    vm = ViewModelProviders.of(this)[UserViewModel::class.java]

    intent?.let {
//      name = it.getda
    }

    vm.fetchUser(name)

    vm.user.observe(this, Observer { data ->
      when(data) {
        is SUCCESS -> {
          vm.fetchUserRepos(name)
        }
        is FAILURE -> {
          // do something when fetching fails
        }
      }
    })

    vm.userRepos.observe(this, Observer { data ->
      when(data) {
        is SUCCESS -> {

        }
        is FAILURE -> {
          // do something when fetching fails
        }
      }
    })
  }

}
