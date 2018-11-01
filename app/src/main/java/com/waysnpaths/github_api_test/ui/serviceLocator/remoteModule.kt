package com.waysnpaths.github_api_test.ui.serviceLocator

import com.waysnpaths.github_api_test.data.remote.SquareGitHubFactory
import com.waysnpaths.github_api_test.data.remote.repo.RemoteRepoRepository
import com.waysnpaths.github_api_test.data.remote.repo.RepoMapper
import com.waysnpaths.github_api_test.data.remote.stargazer.RemoteStargazerRepository
import com.waysnpaths.github_api_test.data.remote.stargazer.StargazerMapper
import com.waysnpaths.github_api_test.domain.repository.RepoRepository
import com.waysnpaths.github_api_test.domain.repository.StargazerRepository
import org.koin.dsl.module.module

val remoteModule = module {
    single {
        SquareGitHubFactory.make()
    }

    factory { RepoMapper() }
    factory { StargazerMapper() }

    factory { RemoteRepoRepository(get(), get()) as RepoRepository }
    factory { RemoteStargazerRepository(get(), get()) as StargazerRepository }
}