package com.waysnpaths.github_api_test.ui.view.reposList

import com.waysnpaths.github_api_test.domain.model.Bookmark
import com.waysnpaths.github_api_test.domain.model.Repo
import com.waysnpaths.github_api_test.domain.repository.BookmarkRepository
import com.waysnpaths.github_api_test.domain.repository.RepoRepository
import com.waysnpaths.github_api_test.ui.Event
import com.waysnpaths.github_api_test.ui.MyViewModel
import com.waysnpaths.github_api_test.ui.routing.RepoDetailsRoute
import com.waysnpaths.github_api_test.ui.routing.RoutingEvent
import com.waysnpaths.github_api_test.ui.util.plusAssign
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.BiFunction
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

class ReposListViewModel(
    private val routingEvent: RoutingEvent,
    private val repoRepository: RepoRepository,
    private val bookmarkRepository: BookmarkRepository
) : MyViewModel<ReposListModel>() {

    fun loadRepos() {
        disposables += repoRepository.get()
            .toObservable()
            .flatMapIterable { it }
            .flatMap { repo -> matchRepoWithBookmark(repo) }
            .map { it -> it.first.apply { bookmark = it.second?.repoName?.isNotEmpty() == true } }
            .toList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(::onReposRetrieved, ::onError)
    }

    private fun matchRepoWithBookmark(repo: Repo): Observable<Pair<Repo, Bookmark?>>? {
        return Observable.zip(
            Observable.just(repo),
            bookmarkRepository.get(repo.name).defaultIfEmpty(Bookmark("")).toObservable(),
            BiFunction<Repo, Bookmark, Pair<Repo, Bookmark?>> { t1, t2 -> t1 to t2 })
    }

    private fun onReposRetrieved(repos: List<Repo>) {
        modelLiveData.value = ReposListModel(repos)
    }

    private fun onError(throwable: Throwable) {
        Timber.e(throwable)
        throwable.message?.let {
            modelLiveData.value = modelLiveData.value?.copy(message = Event(it))
                    ?: ReposListModel(message = Event(it))
        }
    }

    fun routeToDetails(repo: Repo) {
        routingEvent.routeTo(RepoDetailsRoute(repo.name))
    }
}