package com.waysnpaths.github.ui.routing

import androidx.fragment.app.Fragment
import com.waysnpaths.github.ui.view.repoDetails.RepoDetailsFragment
import com.waysnpaths.github.ui.view.reposList.ReposListFragment

sealed class Route() {
    abstract fun newFragment(): Fragment
}

object ReposListRoute : Route() {
    override fun newFragment() = ReposListFragment.newInstance()
}

data class RepoDetailsRoute(val name: String) : Route() {
    override fun newFragment() = RepoDetailsFragment.newInstance(name)
}