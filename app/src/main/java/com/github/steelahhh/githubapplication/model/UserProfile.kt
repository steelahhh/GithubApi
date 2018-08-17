package com.github.steelahhh.githubapplication.model
import com.google.gson.annotations.SerializedName

data class UserProfile(
    @SerializedName("login") val login: String,
    @SerializedName("id") val id: Int,
    @SerializedName("avatar_url") val avatarUrl: String,
    @SerializedName("url") val url: String,
    @SerializedName("name") val name: String,
    @SerializedName("company") val company: String,
    @SerializedName("blog") val blog: String,
    @SerializedName("location") val location: String
)