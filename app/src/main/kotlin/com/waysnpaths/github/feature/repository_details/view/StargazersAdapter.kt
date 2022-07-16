package com.waysnpaths.github.feature.repository_details.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.waysnpaths.github.R
import com.waysnpaths.github.feature.repository_details.domain.Stargazer

class StargazersAdapter : ListAdapter<Stargazer, StargazersAdapter.Holder>(ItemCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(
            LayoutInflater.from(parent.context).inflate(R.layout.stargazer_rv_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = getItem(position)
        holder.apply {
            tvName.text = item.username
            Glide.with(ivAvatar.context)
                .load(item.avatarUrl)
                .into(ivAvatar)
        }
    }

    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        val tvName: TextView = view.findViewById(R.id.tvName)
        val ivAvatar: ImageView = view.findViewById(R.id.ivAvatar)
    }

    class ItemCallback : DiffUtil.ItemCallback<Stargazer>() {
        override fun areItemsTheSame(oldItem: Stargazer, newItem: Stargazer): Boolean {
            return oldItem.username == newItem.username
        }

        override fun areContentsTheSame(oldItem: Stargazer, newItem: Stargazer): Boolean {
            return oldItem == newItem
        }
    }
}
