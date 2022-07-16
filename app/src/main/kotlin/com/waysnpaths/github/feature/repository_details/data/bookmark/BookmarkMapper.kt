package com.waysnpaths.github.data.database.bookmark

import com.waysnpaths.github.domain.Mapper
import com.waysnpaths.github.domain.model.Bookmark

class BookmarkMapper : Mapper<BookmarkEntity, Bookmark> {
    override fun map(from: BookmarkEntity): Bookmark {
        return Bookmark(from.repoName)
    }
}