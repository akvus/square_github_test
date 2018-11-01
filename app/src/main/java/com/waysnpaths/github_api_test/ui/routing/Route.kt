package com.waysnpaths.github_api_test.ui.routing

sealed class Route()

object ReposListRoute : Route()
data class RepoDetailsRoute(val name: String) : Route()