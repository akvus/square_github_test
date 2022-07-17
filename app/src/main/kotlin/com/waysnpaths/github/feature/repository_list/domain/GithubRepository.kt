package com.waysnpaths.github.feature.repository_list.domain

// TODO immutable
data class GithubRepository(
    var name: String = "",
    var stargazersCount: Int = 0,
    var bookmark: Boolean = false
)
