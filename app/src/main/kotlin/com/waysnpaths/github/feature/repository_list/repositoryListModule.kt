package com.waysnpaths.github.feature.repository_list

import com.waysnpaths.github.feature.repository_list.data.SquareGithubFactory
import com.waysnpaths.github.feature.repository_details.data.stargazer.StargazerMapper
import com.waysnpaths.github.feature.repository_details.data.stargazer.RemoteStargazerRepository
import com.waysnpaths.github.feature.repository_details.domain.StargazerRepository
import com.waysnpaths.github.feature.repository_list.data.RemoteGithubRepositoryRepository
import com.waysnpaths.github.feature.repository_list.data.GithubRepositoryMapper
import com.waysnpaths.github.feature.repository_list.domain.GithubRepositoryRepository
import com.waysnpaths.github.feature.repository_list.view.GithubRepositoryListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val githubRepositoryListModule = module {
    viewModel { GithubRepositoryListViewModel(get(), get(), get()) }

    single {
        SquareGithubFactory.make()
    }

    factory { GithubRepositoryMapper() }
    factory { StargazerMapper() }

    factory<GithubRepositoryRepository> { RemoteGithubRepositoryRepository(get(), get()) }
    factory<StargazerRepository> { RemoteStargazerRepository(get(), get()) }
}
