package com.waysnpaths.github_api_test.data.database.bookmark

import com.waysnpaths.github_api_test.domain.Mapper
import com.waysnpaths.github_api_test.domain.model.Bookmark

class BookmarkEntityMapper : Mapper<Bookmark, BookmarkEntity> {
    override fun map(from: Bookmark): BookmarkEntity {
        return BookmarkEntity().apply {
            repoName = from.repoName
        }
    }
}