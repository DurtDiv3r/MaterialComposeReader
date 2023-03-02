package com.example.materialcomposereader.model.service

interface LoginService {
    val currentUserId: String

    suspend fun authenticate(email: String, password: String, route: (Boolean, String) -> Unit)

    suspend fun createUser(
        userName: String,
        email: String,
        password: String,
        route: (Boolean, String) -> Unit,
    )

    suspend fun signOut()
}
