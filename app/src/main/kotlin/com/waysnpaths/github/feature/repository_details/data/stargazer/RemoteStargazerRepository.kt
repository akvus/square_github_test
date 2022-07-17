package com.waysnpaths.github.feature.repository_details.data.stargazer

import com.waysnpaths.github.feature.repository_list.data.SquareGithubInterface
import com.waysnpaths.github.feature.repository_details.domain.Stargazer
import com.waysnpaths.github.feature.repository_details.domain.StargazerRepository
import io.reactivex.Single

class RemoteStargazerRepository(
    private val squareGitHubInterface: SquareGithubInterface,
    private val stargazerMapper: StargazerMapper
) : StargazerRepository {
    override fun get(repoName: String): Single<List<Stargazer>> =
        squareGitHubInterface.getStargazers(repoName)
            .map { stargazerMapper.mapList(it) }
}
