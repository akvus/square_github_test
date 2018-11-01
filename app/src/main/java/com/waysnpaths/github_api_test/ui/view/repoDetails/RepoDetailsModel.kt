package com.waysnpaths.github_api_test.ui.view.repoDetails

import com.waysnpaths.github_api_test.domain.model.Stargazer


data class RepoDetailsModel(
    // todo could have some loading/loaded state
    val stargazers: List<Stargazer>,
    val bookmarked: Boolean
)