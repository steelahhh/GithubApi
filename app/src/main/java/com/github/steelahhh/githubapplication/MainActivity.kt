package com.github.steelahhh.githubapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.steelahhh.githubapplication.network.DataState.FAILURE
import com.github.steelahhh.githubapplication.network.DataState.SUCCESS
import com.mikepenz.fastadapter.IItem
import com.mikepenz.fastadapter.commons.adapters.FastItemAdapter

class MainActivity : AppCompatActivity() {

  private lateinit var vm: UserViewModel

  private var name = "jakewharton"

  private lateinit var recyclerView: RecyclerView
  private lateinit var reposAdapter: FastItemAdapter<IItem<*, *>>

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    vm = ViewModelProviders.of(this)[UserViewModel::class.java]

    recyclerView = findViewById(R.id.userReposList)

    reposAdapter = FastItemAdapter()

    recyclerView.apply {
      adapter = reposAdapter
      layoutManager = LinearLayoutManager(this@MainActivity)
    }

    intent?.let {
      //      name = it.getda
    }

    vm.fetchUser(name)

    vm.user.observe(this, Observer { data ->
      when (data) {
        is SUCCESS -> {
          reposAdapter.add(data.data)
          vm.fetchUserRepos(name)
        }
        is FAILURE -> {
          // do something when fetching fails
        }
      }
    })

    vm.userRepos.observe(this, Observer { data ->
      when (data) {
        is SUCCESS -> {
          reposAdapter.add(data.data)
        }
        is FAILURE -> {
          // do something when fetching fails
        }
      }
    })
  }

}
