package com.jetnews.data.posts.impl

import com.jetnews.data.posts.PostRepository
import com.jetnews.model.Post
import com.jetnews.model.PostsFeed
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.withContext
import com.jetnews.data.Result
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.update

class FakeRepository: PostRepository {

    private val favorites = MutableStateFlow<Set<String>>(setOf())
    private val postFeed = MutableStateFlow<PostsFeed?>(null)

    override suspend fun getPost(postId: String?): Result<Post> {
        return withContext(Dispatchers.IO) {
            val post = posts.allPosts.find { it.id == postId }
            if (post == null) {
                Result.Error(IllegalArgumentException("Post not found"))
            } else {
                Result.Success(post)
            }
        }
    }

    override suspend fun getPostsFeed(): Result<PostsFeed> {
        return withContext(Dispatchers.IO){
            delay(800)
            if(shouldRandomlyFail()){
                Result.Error(IllegalStateException())
            } else{
                postFeed.update { posts }
                Result.Success(posts)
            }
        }
    }

    override fun observeFavorites(): Flow<Set<String>> {
        TODO("Not yet implemented")
    }

    override fun observePostsFeed(): Flow<PostsFeed?> {
        TODO("Not yet implemented")
    }

    override suspend fun toggleFavorite(postId: String) {
        TODO("Not yet implemented")
    }

    private var requestCount = 0
    private fun shouldRandomlyFail(): Boolean = ++requestCount % 5 == 0

}