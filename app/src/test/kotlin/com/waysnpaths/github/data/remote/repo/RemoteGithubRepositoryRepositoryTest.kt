package com.waysnpaths.github.data.remote.repo

import android.annotation.SuppressLint
import com.waysnpaths.github.feature.repository_list.data.SquareGithubInterface
import com.waysnpaths.github.feature.repository_list.domain.GithubRepository
import com.waysnpaths.github.feature.repository_list.data.RemoteGithubRepositoryRepository
import com.waysnpaths.github.feature.repository_list.data.GithubRepositoryMapper
import com.waysnpaths.github.feature.repository_list.data.GithubRepositoryResponse
import io.reactivex.Single
import io.reactivex.observers.TestObserver
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class RemoteGithubRepositoryRepositoryTest {

    @Mock
    lateinit var squareGitHubInterface: SquareGithubInterface

    @Mock
    lateinit var githubRepositoryMapper: GithubRepositoryMapper

    lateinit var remoteRepoRepository: RemoteGithubRepositoryRepository

    val githubRepositoryRespons = listOf(GithubRepositoryResponse().apply {
        name = "test"
        stargazersCount = 3
    })

    val githubRepositories = listOf(GithubRepository().apply {
        name = "test"
        stargazersCount = 3
    })

    @Before
    fun init() {
        remoteRepoRepository = RemoteGithubRepositoryRepository(squareGitHubInterface, githubRepositoryMapper)
    }

    @SuppressLint("CheckResult")
    @Test
    fun `get() with successful response`() {
        `when`(squareGitHubInterface.getRepos()).thenReturn(Single.just(githubRepositoryRespons))
        `when`(githubRepositoryMapper.mapList(githubRepositoryRespons)).thenReturn(githubRepositories)
        val testObserver = TestObserver<List<GithubRepository>>()

        remoteRepoRepository.get().subscribeWith(testObserver)

        testObserver.assertValue(githubRepositories)
    }

    @SuppressLint("CheckResult")
    @Test
    fun `get() with error`() {
        val exception = Exception("Error")
        `when`(squareGitHubInterface.getRepos()).thenReturn(Single.error(exception))
        val testObserver = TestObserver<List<GithubRepository>>()

        remoteRepoRepository.get().subscribeWith(testObserver)

        testObserver.assertError(exception)
    }
}
