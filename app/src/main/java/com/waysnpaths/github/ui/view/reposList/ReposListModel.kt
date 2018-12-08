package com.waysnpaths.github.ui.view.reposList

import com.waysnpaths.github.domain.model.Repo
import com.waysnpaths.github.ui.Event

data class ReposListModel(
    // todo could be some loading/loaded state
    val repos: List<Repo> = listOf(),
    val message: Event<String>? = null
)