package com.github.steelahhh.githubapplication.model
import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import com.bumptech.glide.Glide
import com.github.steelahhh.githubapplication.R
import com.google.gson.annotations.SerializedName
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.AbstractItem

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
): AbstractItem<UserRepo, UserRepo.ViewHolder>() {
  override fun getType() = R.id.repositoryItem

  override fun getViewHolder(v: View) = ViewHolder(v)

  override fun getLayoutRes() = R.layout.item_repository

  inner class ViewHolder(itemView: View): FastAdapter.ViewHolder<UserRepo>(itemView) {
    private  val repositoryName = itemView.findViewById<AppCompatTextView>(R.id.repositoryName)
    private val repositoryDescription = itemView.findViewById<AppCompatTextView>(R.id.repositoryDescription)
    private val starsCount = itemView.findViewById<AppCompatTextView>(R.id.repositoryStarsCount)

    override fun unbindView(item: UserRepo) {
      repositoryName.text = null
      repositoryDescription.text = null
      starsCount.text = null
    }

    override fun bindView(item: UserRepo, payloads: MutableList<Any>) {
      repositoryName.text = item.name
      repositoryDescription.text = item.description
      starsCount.text = "${item.stargazersCount}"
    }

  }
}

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