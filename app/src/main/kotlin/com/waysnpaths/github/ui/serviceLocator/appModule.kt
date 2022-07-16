package com.waysnpaths.github.ui.serviceLocator

import com.waysnpaths.github.ui.routing.Router
import org.koin.dsl.module.module


val appModule = module {
    factory {
        Router
    }
}