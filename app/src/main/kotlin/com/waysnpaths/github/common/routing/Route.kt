package com.waysnpaths.github.common.routing

import androidx.fragment.app.Fragment
import com.waysnpaths.github.feature.repository_details.view.GithubRepositoryDetailsFragment
import com.waysnpaths.github.feature.repository_list.view.GithubRepositoryListFragment

sealed class Route {
    abstract fun newFragment(): Fragment
}

object ReposListRoute : Route() {
    override fun newFragment() = GithubRepositoryListFragment.newInstance()
}

data class RepoDetailsRoute(val name: String) : Route() {
    override fun newFragment() = GithubRepositoryDetailsFragment.newInstance(name)
}
