package com.waysnpaths.github_api_test.data.remote.repo

import com.waysnpaths.github_api_test.domain.Mapper
import com.waysnpaths.github_api_test.domain.model.Repo

class RepoMapper : Mapper<RepoResponse, Repo> {
    override fun map(from: RepoResponse): Repo {
        return Repo().apply {
            name = from.name
            stargazersCount = from.stargazersCount
        }
    }
}