package com.waysnpaths.github.feature.repository_details.view

import com.waysnpaths.github.feature.repository_details.domain.Stargazer


data class RepoDetailsModel(
    // todo could have some loading/loaded state
    val stargazers: List<Stargazer>,
    val bookmarked: Boolean
)
