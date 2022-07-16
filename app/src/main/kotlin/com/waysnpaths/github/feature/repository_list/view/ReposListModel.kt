package com.waysnpaths.github.feature.repository_list.view

import com.waysnpaths.github.common.view.Event
import com.waysnpaths.github.feature.repository_list.domain.Repo

data class ReposListModel(
    // todo could be some loading/loaded state
    val repos: List<Repo> = listOf(),
    val message: Event<String>? = null
)
