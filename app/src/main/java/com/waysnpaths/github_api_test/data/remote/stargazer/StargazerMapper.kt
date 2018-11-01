package com.waysnpaths.github_api_test.data.remote.stargazer

import com.waysnpaths.github_api_test.domain.Mapper
import com.waysnpaths.github_api_test.domain.model.Stargazer

class StargazerMapper : Mapper<StargazerResponse, Stargazer> {
    override fun map(from: StargazerResponse): Stargazer {
        return Stargazer().apply {
            username = from.login
            avatarUrl = from.avatarUrl
        }
    }
}