package com.jetnews.data.posts

import com.jetnews.model.Post
import com.jetnews.model.PostsFeed
import kotlinx.coroutines.flow.Flow
import com.jetnews.data.Result

interface PostRepository {
    suspend fun getPost(postId: String?): Result<Post>

    suspend fun getPostsFeed(): Result<PostsFeed>

    fun observeFavorites(): Flow<Set<String>>

    fun observePostsFeed(): Flow<PostsFeed?>

    suspend fun toggleFavorite(postId: String)
}
