package com.waysnpaths.github.feature.repository_list.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.waysnpaths.github.R
import com.waysnpaths.github.feature.repository_list.domain.GithubRepository
import io.reactivex.subjects.PublishSubject

class GithubRepositoryListAdapter : ListAdapter<GithubRepository, GithubRepositoryListAdapter.Holder>(ItemCallback()) {
    val onClickSubject = PublishSubject.create<GithubRepository>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(
            LayoutInflater.from(parent.context).inflate(R.layout.repo_rv_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = getItem(position)
        holder.apply {
            tvName.text = item.name
            tvStarsGazer.text = item.stargazersCount.toString()
            itemView.setOnClickListener { onClickSubject.onNext(getItem(holder.bindingAdapterPosition)) }
            ivStar.visibility = if (item.bookmark) View.VISIBLE else View.GONE
        }
    }

    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        val tvName: TextView = view.findViewById(R.id.tvName)
        val tvStarsGazer: TextView = view.findViewById(R.id.tvStargazer)
        val ivStar: ImageView = view.findViewById(R.id.ivStar)
    }

    class ItemCallback : DiffUtil.ItemCallback<GithubRepository>() {
        override fun areItemsTheSame(oldItem: GithubRepository, newItem: GithubRepository): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: GithubRepository, newItem: GithubRepository): Boolean {
            return oldItem == newItem
        }
    }
}
