package com.waysnpaths.github.data.database.bookmark

import com.waysnpaths.github.domain.Mapper
import com.waysnpaths.github.domain.model.Bookmark

class BookmarkEntityMapper : Mapper<Bookmark, BookmarkEntity> {
    override fun map(from: Bookmark): BookmarkEntity {
        return BookmarkEntity().apply {
            repoName = from.repoName
        }
    }
}