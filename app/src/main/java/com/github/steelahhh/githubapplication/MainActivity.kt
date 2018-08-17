package com.github.steelahhh.githubapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders

class MainActivity : AppCompatActivity() {

  private lateinit var vm: UserViewModel

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    vm = ViewModelProviders.of(this)[UserViewModel::class.java]
  }

}
