package com.waysnpaths.github.common.routing

import androidx.fragment.app.Fragment
import com.waysnpaths.github.feature.repository_details.view.RepoDetailsFragment
import com.waysnpaths.github.feature.repository_list.view.ReposListFragment

sealed class Route {
    abstract fun newFragment(): Fragment
}

object ReposListRoute : Route() {
    override fun newFragment() = ReposListFragment.newInstance()
}

data class RepoDetailsRoute(val name: String) : Route() {
    override fun newFragment() = RepoDetailsFragment.newInstance(name)
}
