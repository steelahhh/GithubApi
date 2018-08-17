package com.github.steelahhh.githubapplication

import androidx.lifecycle.ViewModel
import com.github.steelahhh.githubapplication.network.RepositoryService

class UserViewModel: ViewModel() {
  // normally this would be constructor injected
  private val service = RepositoryService()

}