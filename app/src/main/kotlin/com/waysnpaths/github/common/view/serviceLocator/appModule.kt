package com.waysnpaths.github.common.view.serviceLocator

import com.waysnpaths.github.common.view.routing.Router
import org.koin.dsl.module

val appModule = module {
    factory {
        Router
    }
}
