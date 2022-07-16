package com.waysnpaths.github.feature.repository_list

import com.waysnpaths.github.feature.repository_list.view.ReposListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val repositoryListModule = module {
    viewModel { ReposListViewModel(get(), get(), get()) }
}
