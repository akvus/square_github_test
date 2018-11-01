package com.waysnpaths.github_api_test.data.database.bookmark

import com.waysnpaths.github_api_test.domain.Mapper
import com.waysnpaths.github_api_test.domain.model.Bookmark

class BookmarkMapper : Mapper<BookmarkEntity, Bookmark> {
    override fun map(from: BookmarkEntity): Bookmark {
        return Bookmark(from.repoName)
    }
}