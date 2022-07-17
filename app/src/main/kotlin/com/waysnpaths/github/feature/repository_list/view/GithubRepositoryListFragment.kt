package com.waysnpaths.github.feature.repository_list.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.fragment.app.Fragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class GithubRepositoryListFragment : Fragment() {
    private val viewModel: GithubRepositoryListViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(requireContext()).apply {
        setContent { GithubRepositoryList(viewModel) }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (savedInstanceState == null)
            viewModel.loadRepos()
    }
    companion object {
        fun newInstance() = GithubRepositoryListFragment()
    }
}

@Composable
private fun GithubRepositoryList(viewModel: GithubRepositoryListViewModel) {
    val model by viewModel.getModel().observeAsState()
    val image: Painter = painterResource(id = android.R.drawable.star_on)
    val message = model?.message?.getContentIfNotHandled()

    LazyColumn(
        contentPadding = PaddingValues(all = Dp(16f))
    ) {
        // TODO proper viewState handle (error, loading, data, empty)
        if (message != null)
            item { Text(message, color = Color.Red) }

        items(model?.githubRepositories ?: listOf()) { repository ->
            Row(
                modifier = Modifier
                    .clickable {
                        viewModel.routeToDetails(repository)
                    }
                    .fillMaxWidth()
                    .padding(Dp(16f)),
                horizontalArrangement = Arrangement.spacedBy(Dp(8f))
            ) {
                Text(text = repository.name)
                Text(text = repository.stargazersCount.toString())
                if (repository.bookmark)
                    Image(painter = image, contentDescription = "Bookmarked")
            }
        }
    }
}
