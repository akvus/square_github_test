package com.waysnpaths.github.feature.repository_list.view

import com.waysnpaths.github.common.layer.view.Event
import com.waysnpaths.github.feature.repository_list.domain.GithubRepository

data class GithubRepositoryListModel(
    // todo could be some loading/loaded state
    val githubRepositories: List<GithubRepository> = listOf(),
    val message: Event<String>? = null
)
