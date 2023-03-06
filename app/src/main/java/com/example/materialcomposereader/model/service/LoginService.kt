package com.example.materialcomposereader.model.service

import com.example.materialcomposereader.model.User
import kotlinx.coroutines.flow.Flow

interface LoginService {
    val currentUserId: String
    val hasUser: Boolean
    val currentUser: Flow<User>
    suspend fun authenticate(email: String, password: String)

    suspend fun createUser(
        userName: String,
        email: String,
        password: String,
    )

    suspend fun signOut()
}
