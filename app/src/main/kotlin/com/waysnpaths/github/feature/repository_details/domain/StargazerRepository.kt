package com.waysnpaths.github.feature.repository_details.domain

import io.reactivex.Single

interface StargazerRepository {
    fun get(repoName: String): Single<List<Stargazer>>
}
