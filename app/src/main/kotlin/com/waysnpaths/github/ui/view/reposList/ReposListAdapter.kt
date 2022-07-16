package com.waysnpaths.github.ui.view.reposList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.waysnpaths.github.R
import com.waysnpaths.github.domain.model.Repo
import io.reactivex.subjects.PublishSubject

class ReposListAdapter : ListAdapter<Repo, ReposListAdapter.Holder>(ItemCallback()) {
    val onClickSubject = PublishSubject.create<Repo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(LayoutInflater.from(parent.context).inflate(R.layout.repo_rv_item, parent, false))
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = getItem(position)
        holder.apply {
            tvName.text = item.name
            tvStarsgazer.text = item.stargazersCount.toString()
            itemView.setOnClickListener { onClickSubject.onNext(getItem(holder.adapterPosition)) }
            ivStar.visibility = if(item.bookmark) View.VISIBLE else View.GONE
        }
    }

    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        val tvName: TextView = view.findViewById(R.id.tvName)
        val tvStarsgazer: TextView = view.findViewById(R.id.tvStargazer)
        val ivStar: ImageView = view.findViewById(R.id.ivStar)
    }

    class ItemCallback : DiffUtil.ItemCallback<Repo>() {
        override fun areItemsTheSame(oldItem: Repo, newItem: Repo): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Repo, newItem: Repo): Boolean {
            return oldItem == newItem
        }
    }
}