package com.waysnpaths.github.feature.repository_details.view

import com.waysnpaths.github.common.layer.view.MyViewModel
import com.waysnpaths.github.common.extension.plusAssign
import com.waysnpaths.github.feature.repository_details.domain.Bookmark
import com.waysnpaths.github.feature.repository_details.domain.BookmarkRepository
import com.waysnpaths.github.feature.repository_details.domain.Stargazer
import com.waysnpaths.github.feature.repository_details.domain.StargazerRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

// todo caching the result
class RepoDetailsViewModel(
    private val stargazerRepository: StargazerRepository,
    private val bookmarkRepository: BookmarkRepository
) : MyViewModel<RepoDetailsModel>() {

    init {
        modelLiveData.value = RepoDetailsModel(listOf(), false)
    }

    fun checkBookmark(repoName: String) {
        disposables += bookmarkRepository.get(repoName)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ bookmarkFound(true) }, { bookmarkFound(false) })
    }

    private fun bookmarkFound(bookmark: Boolean) {
        modelLiveData.value = modelLiveData.value?.copy(bookmarked = bookmark)
    }

    fun loadStargazers(repoName: String) {
        disposables += stargazerRepository.get(repoName)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(::onStargazersReceived, ::onError)
    }

    private fun onStargazersReceived(stargazers: List<Stargazer>) {
        modelLiveData.value = modelLiveData.value?.copy(stargazers = stargazers)
    }

    private fun onError(throwable: Throwable) {
        Timber.e(throwable)
        // todo notify
    }

    fun onBookmark(repoName: String) {
        disposables += bookmarkRepository.add(Bookmark(repoName))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ checkBookmark(repoName) }, ::onError)
    }

    fun onRemoveBookmark(repoName: String) {
        disposables += bookmarkRepository.delete(Bookmark(repoName))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ checkBookmark(repoName) }, ::onError)
    }
}
