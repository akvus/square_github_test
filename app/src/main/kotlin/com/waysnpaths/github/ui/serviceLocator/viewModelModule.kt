package com.waysnpaths.github.ui.serviceLocator

import com.waysnpaths.github.ui.view.main.MainViewModel
import com.waysnpaths.github.ui.view.repoDetails.RepoDetailsViewModel
import com.waysnpaths.github.ui.view.reposList.ReposListViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val viewModelModule = module {
    viewModel { MainViewModel(get()) }

    viewModel { ReposListViewModel(get(), get(), get()) }
    viewModel { RepoDetailsViewModel(get(), get() ) }
}