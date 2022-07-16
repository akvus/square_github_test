package com.waysnpaths.github.ui.serviceLocator

import com.waysnpaths.github.data.remote.SquareGitHubFactory
import com.waysnpaths.github.data.remote.repo.RemoteRepoRepository
import com.waysnpaths.github.data.remote.repo.RepoMapper
import com.waysnpaths.github.data.remote.stargazer.RemoteStargazerRepository
import com.waysnpaths.github.data.remote.stargazer.StargazerMapper
import com.waysnpaths.github.domain.repository.RepoRepository
import com.waysnpaths.github.domain.repository.StargazerRepository
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