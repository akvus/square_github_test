package com.waysnpaths.github.feature.repository_details.data.stargazer

import com.waysnpaths.github.common.layer.data.Mapper
import com.waysnpaths.github.feature.repository_details.domain.Stargazer

class StargazerMapper : Mapper<StargazerResponse, Stargazer> {
    override fun map(from: StargazerResponse): Stargazer =
        Stargazer(username = from.login, avatarUrl = from.avatarUrl)
}
