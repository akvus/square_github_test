package com.waysnpaths.github_api_test.data.remote.repo

import com.waysnpaths.github_api_test.data.remote.SuqareGitHubInterface
import com.waysnpaths.github_api_test.domain.model.Repo
import com.waysnpaths.github_api_test.domain.repository.RepoRepository
import io.reactivex.Single

class RemoteRepoRepository(
    private val squareGitHubInterface: SuqareGitHubInterface,
    private val repoMapper: RepoMapper
) : RepoRepository {
    override fun get(): Single<List<Repo>> {
        return squareGitHubInterface.getRepos()
            .map { repo -> repoMapper.mapList(repo) }
    }
}