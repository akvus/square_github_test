package com.waysnpaths.github.feature.repository_list.domain

data class GithubRepository(
    val name: String = "",
    val stargazersCount: Int = 0,
    val bookmark: Boolean = false
)
