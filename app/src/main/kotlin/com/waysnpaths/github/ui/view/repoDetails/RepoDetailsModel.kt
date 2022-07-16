package com.waysnpaths.github.ui.view.repoDetails

import com.waysnpaths.github.domain.model.Stargazer


data class RepoDetailsModel(
    // todo could have some loading/loaded state
    val stargazers: List<Stargazer>,
    val bookmarked: Boolean
)