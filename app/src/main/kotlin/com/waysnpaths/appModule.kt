package com.waysnpaths.github.common.layer.view.serviceLocator

import com.waysnpaths.github.common.routing.Router
import org.koin.dsl.module

val appModule = module {
    factory {
        Router
    }
}
