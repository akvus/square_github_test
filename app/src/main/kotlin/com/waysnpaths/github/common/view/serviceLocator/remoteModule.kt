package com.waysnpaths.github.common.view.serviceLocator

import com.waysnpaths.github.common.data.remote.SquareGithubFactory
import com.waysnpaths.github.feature.repository_list.data.repo.RepoMapper
import com.waysnpaths.github.data.remote.stargazer.StargazerMapper
import com.waysnpaths.github.feature.repository_details.data.stargazer.RemoteStargazerRepository
import com.waysnpaths.github.feature.repository_list.data.repo.RemoteRepoRepository
import org.koin.dsl.module


val remoteModule = module {
    single {
        SquareGithubFactory.make()
    }

    factory { RepoMapper() }
    factory { StargazerMapper() }

    factory { RemoteRepoRepository(get(), get()) }
    factory { RemoteStargazerRepository(get(), get()) }
}
