package com.waysnpaths.github_api_test.ui.view.main

import com.waysnpaths.github_api_test.ui.MyViewModel
import com.waysnpaths.github_api_test.ui.routing.ReposListRoute
import com.waysnpaths.github_api_test.ui.routing.RoutingEvent
import com.waysnpaths.github_api_test.ui.util.plusAssign

class MainViewModel(
    private val routingEvent: RoutingEvent
) : MyViewModel<MainModel>() {

    fun onInit() {
        disposables += routingEvent.routing.subscribe { route ->
            modelLiveData.value = MainModel(route)
        }
    }

    fun goToReposList() {
        routingEvent.routeTo(ReposListRoute)
    }
}