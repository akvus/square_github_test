package com.waysnpaths.github_api_test.ui.routing

import io.reactivex.subjects.BehaviorSubject

object RoutingEvent {
    val routing by lazy { BehaviorSubject.create<Route>() }

    fun routeTo(route: Route) {
        routing.onNext(route)
    }
}