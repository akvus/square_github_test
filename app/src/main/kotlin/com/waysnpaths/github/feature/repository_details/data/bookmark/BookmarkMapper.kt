package com.waysnpaths.github.feature.repository_details.data.bookmark

import com.waysnpaths.github.common.layer.data.Mapper
import com.waysnpaths.github.feature.repository_details.domain.Bookmark

class BookmarkMapper : Mapper<BookmarkEntity, Bookmark> {
    override fun map(from: BookmarkEntity): Bookmark {
        return Bookmark(from.repoName)
    }
}
