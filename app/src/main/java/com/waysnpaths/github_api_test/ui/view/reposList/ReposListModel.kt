package com.waysnpaths.github_api_test.ui.view.reposList

import com.waysnpaths.github_api_test.domain.model.Repo
import com.waysnpaths.github_api_test.ui.Event

data class ReposListModel(
    // todo could be some loading/loaded state
    val repos: List<Repo> = listOf(),
    val message: Event<String>? = null
)