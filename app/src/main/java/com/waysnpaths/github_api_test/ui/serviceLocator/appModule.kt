package com.waysnpaths.github_api_test.ui.serviceLocator

import com.waysnpaths.github_api_test.ui.routing.RoutingEvent
import org.koin.dsl.module.module


val appModule = module {
    factory {
        RoutingEvent
    }
}