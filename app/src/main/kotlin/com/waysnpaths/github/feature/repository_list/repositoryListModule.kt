package com.waysnpaths.github.feature.repository_list

import com.waysnpaths.github.feature.repository_list.data.SquareGithubFactory
import com.waysnpaths.github.data.remote.stargazer.StargazerMapper
import com.waysnpaths.github.feature.repository_details.data.stargazer.RemoteStargazerRepository
import com.waysnpaths.github.feature.repository_details.domain.StargazerRepository
import com.waysnpaths.github.feature.repository_list.data.RemoteRepoRepository
import com.waysnpaths.github.feature.repository_list.data.RepoMapper
import com.waysnpaths.github.feature.repository_list.domain.RepoRepository
import com.waysnpaths.github.feature.repository_list.view.ReposListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val repositoryListModule = module {
    viewModel { ReposListViewModel(get(), get(), get()) }

    single {
        SquareGithubFactory.make()
    }

    factory { RepoMapper() }
    factory { StargazerMapper() }

    factory<RepoRepository> { RemoteRepoRepository(get(), get()) }
    factory<StargazerRepository> { RemoteStargazerRepository(get(), get()) }
}
