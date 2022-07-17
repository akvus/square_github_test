package com.waysnpaths.github.feature.repository_list.data

import com.waysnpaths.github.feature.repository_list.domain.Repo
import com.waysnpaths.github.feature.repository_list.domain.RepoRepository
import io.reactivex.Single

class RemoteRepoRepository(
    private val squareGitHubInterface: SquareGithubInterface,
    private val repoMapper: RepoMapper
) : RepoRepository {
    override fun get(): Single<List<Repo>> {
        return squareGitHubInterface.getRepos()
            .map { repo -> repoMapper.mapList(repo) }
    }
}
