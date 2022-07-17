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
class GithubRepositoryDetailsViewModel(
    private val stargazerRepository: StargazerRepository,
    private val bookmarkRepository: BookmarkRepository
) : MyViewModel<GithubRepositoryDetailsModel>() {
    init {
        modelLiveData.value = GithubRepositoryDetailsModel(listOf(), false)
    }

    fun checkBookmark(repoName: String) {
        disposables += bookmarkRepository.get(repoName)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ onBookmarkedStatusFound(true) }, { onBookmarkedStatusFound(false) })
    }

    private fun onBookmarkedStatusFound(isBookmarked: Boolean) {
        modelLiveData.value = modelLiveData.value?.copy(bookmarked = isBookmarked)
    }

    fun loadStargazers(githubRepositoryName: String) {
        disposables += stargazerRepository.get(githubRepositoryName)
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

    fun onChangeBookmarking(githubRepositoryName: String) {
        val completable = if (modelLiveData.value!!.bookmarked) {
            bookmarkRepository.add(Bookmark(githubRepositoryName))
        } else bookmarkRepository.delete(Bookmark(githubRepositoryName))

        disposables +=
            completable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ checkBookmark(githubRepositoryName) }, ::onError)
    }
}
