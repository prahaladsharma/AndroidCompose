package com.jetnews.data

import android.content.Context
import com.jetnews.data.posts.PostRepository
import com.jetnews.data.posts.impl.FakeRepository

/**
 * Dependency Injection container at the application level.
 */
interface AppContainer {
    val postsRepository: PostRepository
}

/**
 * Implementation for the Dependency Injection container at the application level.
 * Variables are initialized lazily and the same instance is shared across the whole app.
 */
class AppContainerImpl(private val applicationContext: Context) : AppContainer {
    override val postsRepository: PostRepository by lazy {
        FakeRepository()
    }
}