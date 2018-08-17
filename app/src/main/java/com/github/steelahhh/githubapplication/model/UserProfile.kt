package com.github.steelahhh.githubapplication.model

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.github.steelahhh.githubapplication.R
import com.google.gson.annotations.SerializedName
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.AbstractItem

data class UserProfile(
    @SerializedName("login") val login: String,
    @SerializedName("id") val id: Int,
    @SerializedName("avatar_url") val avatarUrl: String,
    @SerializedName("url") val url: String,
    @SerializedName("name") val name: String,
    @SerializedName("company") val company: String,
    @SerializedName("blog") val blog: String,
    @SerializedName("location") val location: String
) : AbstractItem<UserProfile, UserProfile.ViewHolder>() {
  override fun getType() = R.id.userItem

  override fun getViewHolder(v: View) = ViewHolder(v)

  override fun getLayoutRes() = R.layout.item_user

  inner class ViewHolder(itemView: View) : FastAdapter.ViewHolder<UserProfile>(itemView) {
    private val userImage = itemView.findViewById<AppCompatImageView>(R.id.userAvatar)
    private val userName = itemView.findViewById<AppCompatTextView>(R.id.userName)

    override fun unbindView(item: UserProfile) {
      userName.text = null
    }

    override fun bindView(item: UserProfile, payloads: MutableList<Any>) {
      userName.text = item.name
      Glide.with(itemView.context)
          .load(item.avatarUrl)
          .apply(RequestOptions().centerCrop())
          .into(userImage)
    }

  }
}
