package com.waysnpaths.github.data.remote.stargazer

import com.waysnpaths.github.common.data.Mapper
import com.waysnpaths.github.feature.repository_details.domain.Stargazer

class StargazerMapper : Mapper<StargazerResponse, Stargazer> {
    override fun map(from: StargazerResponse): Stargazer {
        return Stargazer().apply {
            username = from.login
            avatarUrl = from.avatarUrl
        }
    }
}
