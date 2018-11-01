package com.waysnpaths.github_api_test.domain.repository

import com.waysnpaths.github_api_test.domain.model.Stargazer
import io.reactivex.Single

interface StargazerRepository {
    fun get(repoName: String) : Single<List<Stargazer>>
}