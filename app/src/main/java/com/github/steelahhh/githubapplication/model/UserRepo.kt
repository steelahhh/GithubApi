package com.github.steelahhh.githubapplication.model
import com.google.gson.annotations.SerializedName

data class UserRepo(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("owner") val owner: Owner,
    @SerializedName("private") val private: Boolean,
    @SerializedName("html_url") val htmlUrl: String,
    @SerializedName("description") val description: String,
    @SerializedName("fork") val fork: Boolean,
    @SerializedName("url") val url: String,
    @SerializedName("stargazers_count") val stargazersCount: Int,
    @SerializedName("watchers_count") val watchersCount: Int
)

data class Owner(
    @SerializedName("login") val login: String,
    @SerializedName("id") val id: Int,
    @SerializedName("node_id") val nodeId: String,
    @SerializedName("avatar_url") val avatarUrl: String,
    @SerializedName("gravatar_id") val gravatarId: String,
    @SerializedName("url") val url: String,
    @SerializedName("html_url") val htmlUrl: String,
    @SerializedName("followers_url") val followersUrl: String,
    @SerializedName("following_url") val followingUrl: String,
    @SerializedName("gists_url") val gistsUrl: String,
    @SerializedName("starred_url") val starredUrl: String,
    @SerializedName("subscriptions_url") val subscriptionsUrl: String,
    @SerializedName("organizations_url") val organizationsUrl: String,
    @SerializedName("repos_url") val reposUrl: String,
    @SerializedName("events_url") val eventsUrl: String,
    @SerializedName("received_events_url") val receivedEventsUrl: String,
    @SerializedName("type") val type: String,
    @SerializedName("site_admin") val siteAdmin: Boolean
)