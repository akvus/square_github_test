package com.waysnpaths.github.feature.repository_details.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import coil.compose.rememberAsyncImagePainter
import org.koin.androidx.viewmodel.ext.android.viewModel

class GithubRepositoryDetailsFragment : Fragment() {
    private val viewModel: GithubRepositoryDetailsViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(requireContext()).apply {
        setContent { GithubRepositoryDetails(viewModel, getRepoName()) }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (savedInstanceState == null) {
            with(getRepoName()) {
                viewModel.loadStargazers(this)
                viewModel.checkBookmark(this)
            }
        }
    }

    private fun getRepoName(): String = arguments!!.getString(nameArgument)!! // crash otherwise

    companion object {
        private const val nameArgument = "name"

        fun newInstance(repoName: String) = GithubRepositoryDetailsFragment().apply {
            arguments = Bundle().apply {
                putString(nameArgument, repoName)
            }
        }
    }
}


@Composable
private fun GithubRepositoryDetails(viewModel: GithubRepositoryDetailsViewModel,  repositoryName:String) {
    val model by viewModel.getModel().observeAsState()
    val isBookmarked = model?.bookmarked ?: false;
    val stargazers = model?.stargazers ?: listOf()

    LazyColumn(
        contentPadding = PaddingValues(16.dp)
    ) {
        item {
            Button(onClick = {
                viewModel.onChangeBookmarking(repositoryName)
                // TODO there is also onRemoveBookmark - > make both be one
            }) {
                Text(if (isBookmarked) "Remove bookmark" else "Bookmark")
            }
        }

        items(stargazers) { stargazer ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Image(
                    painter = rememberAsyncImagePainter(stargazer.avatarUrl),
                    contentDescription = null,
                    modifier = Modifier.size(64.dp)
                )
                Text(stargazer.username)
            }
        }
    }
}
