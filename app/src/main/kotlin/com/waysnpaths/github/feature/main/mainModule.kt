package com.waysnpaths.github.feature.main

import com.waysnpaths.github.feature.main.view.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {
    viewModel { MainViewModel(get()) }
}
