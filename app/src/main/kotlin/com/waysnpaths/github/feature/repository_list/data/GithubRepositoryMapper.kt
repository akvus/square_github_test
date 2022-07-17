package com.waysnpaths.github.feature.repository_list.data

import com.waysnpaths.github.common.layer.data.Mapper
import com.waysnpaths.github.feature.repository_list.domain.GithubRepository

class GithubRepositoryMapper : Mapper<GithubRepositoryResponse, GithubRepository> {
    override fun map(from: GithubRepositoryResponse): GithubRepository {
        return GithubRepository().apply {
            name = from.name
            stargazersCount = from.stargazersCount
        }
    }
}
