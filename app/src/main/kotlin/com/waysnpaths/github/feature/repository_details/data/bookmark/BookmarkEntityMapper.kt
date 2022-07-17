package com.waysnpaths.github.feature.repository_details.data.bookmark

import com.waysnpaths.github.common.layer.data.Mapper
import com.waysnpaths.github.feature.repository_details.domain.Bookmark

class BookmarkEntityMapper : Mapper<Bookmark, BookmarkEntity> {
    override fun map(from: Bookmark): BookmarkEntity = BookmarkEntity(githubRepositoryName = from.githubRepositoryName)
}
