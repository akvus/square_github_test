package com.waysnpaths.github.feature.repository_details

import com.waysnpaths.github.feature.repository_details.view.RepoDetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val repositoryDetailsModule = module {
    viewModel { RepoDetailsViewModel(get(), get()) }
}
