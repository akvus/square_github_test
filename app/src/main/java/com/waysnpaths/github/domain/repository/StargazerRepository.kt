package com.waysnpaths.github.domain.repository

import com.waysnpaths.github.domain.model.Stargazer
import io.reactivex.Single

interface StargazerRepository {
    fun get(repoName: String) : Single<List<Stargazer>>
}