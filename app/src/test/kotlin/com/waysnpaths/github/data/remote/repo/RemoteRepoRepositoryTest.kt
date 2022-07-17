package com.waysnpaths.github.data.remote.repo

import com.waysnpaths.github.feature.repository_list.data.SquareGithubInterface
import com.waysnpaths.github.feature.repository_list.domain.Repo
import com.waysnpaths.github.feature.repository_list.data.RemoteRepoRepository
import com.waysnpaths.github.feature.repository_list.data.RepoMapper
import com.waysnpaths.github.feature.repository_list.data.RepoResponse
import io.reactivex.Single
import io.reactivex.observers.TestObserver
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class RemoteRepoRepositoryTest {

    @Mock
    lateinit var squareGitHubInterface: SquareGithubInterface

    @Mock
    lateinit var repoMapper: RepoMapper

    lateinit var remoteRepoRepository: RemoteRepoRepository

    val repoResponses = listOf(RepoResponse().apply {
        name = "test"
        stargazersCount = 3
    })

    val repos = listOf(Repo().apply {
        name = "test"
        stargazersCount = 3
    })

    @Before
    fun init() {
        remoteRepoRepository = RemoteRepoRepository(squareGitHubInterface, repoMapper)
    }

    @Test
    fun `get() with successful response`() {
        `when`(squareGitHubInterface.getRepos()).thenReturn(Single.just(repoResponses))
        `when`(repoMapper.mapList(repoResponses)).thenReturn(repos)
        val testObserver = TestObserver<List<Repo>>()

        remoteRepoRepository.get().subscribeWith(testObserver)

        testObserver.assertValue(repos)
    }

    @Test
    fun `get() with error`() {
        val exception = Exception("Error")
        `when`(squareGitHubInterface.getRepos()).thenReturn(Single.error(exception))
        val testObserver = TestObserver<List<Repo>>()

        remoteRepoRepository.get().subscribeWith(testObserver)

        testObserver.assertError(exception)
    }
}
