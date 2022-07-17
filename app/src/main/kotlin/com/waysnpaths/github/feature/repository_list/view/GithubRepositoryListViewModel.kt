package com.waysnpaths.github.feature.repository_list.view

import com.waysnpaths.github.common.layer.view.Event
import com.waysnpaths.github.common.layer.view.MyViewModel
import com.waysnpaths.github.common.routing.RepoDetailsRoute
import com.waysnpaths.github.common.routing.Router
import com.waysnpaths.github.common.extension.plusAssign
import com.waysnpaths.github.feature.repository_list.domain.GithubRepository
import com.waysnpaths.github.feature.repository_list.domain.GithubRepositoryRepository
import com.waysnpaths.github.feature.repository_details.domain.Bookmark
import com.waysnpaths.github.feature.repository_details.domain.BookmarkRepository
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.BiFunction
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

class GithubRepositoryListViewModel(
    private val routingEvent: Router,
    private val githubRepositoryRepository: GithubRepositoryRepository,
    private val bookmarkRepository: BookmarkRepository
) : MyViewModel<GithubRepositoryListModel>() {

    fun loadRepos() {
        disposables += githubRepositoryRepository.get()
            .toObservable()
            .flatMapIterable { it }
            .flatMap { repo -> matchRepoWithBookmark(repo) }
            .map { it -> it.first.apply { bookmark = it.second?.repoName?.isNotEmpty() == true } }
            .toList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(::onReposRetrieved, ::onError)
    }

    private fun matchRepoWithBookmark(githubRepository: GithubRepository): Observable<Pair<GithubRepository, Bookmark?>>? {
        return Observable.zip(
            Observable.just(githubRepository),
            bookmarkRepository.get(githubRepository.name).defaultIfEmpty(Bookmark("")).toObservable()
        ) { t1, t2 -> t1 to t2 }
    }

    private fun onReposRetrieved(githubRepositories: List<GithubRepository>) {
        modelLiveData.value = GithubRepositoryListModel(githubRepositories)
    }

    private fun onError(throwable: Throwable) {
        Timber.e(throwable)
        throwable.message?.let {
            modelLiveData.value = modelLiveData.value?.copy(message = Event(it))
                ?: GithubRepositoryListModel(message = Event(it))
        }
    }

    fun routeToDetails(githubRepository: GithubRepository) {
        routingEvent.routeTo(RepoDetailsRoute(githubRepository.name))
    }
}
