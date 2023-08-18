package com.chatapp.ktorandroidchat.data.remote

import com.chatapp.ktorandroidchat.domain.model.Message
import com.chatapp.ktorandroidchat.util.Resource
import kotlinx.coroutines.flow.Flow

interface ChatSocketService {

    suspend fun initSession(
        username: String,
    ): Resource<Unit>

    suspend fun sendMessage(message: String)

    fun observerMessages(): Flow<Message>

    suspend fun closeSession()

    companion object {
        const val BASE_URL = "ws://localhost:8080"
    }

    sealed class Endpoints(val url: String) {
        object ChatSocket : Endpoints("$BASE_URL/chat-socket")
    }
}