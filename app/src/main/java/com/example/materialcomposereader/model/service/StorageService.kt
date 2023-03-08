package com.example.materialcomposereader.model.service

interface StorageService {
    suspend fun saveUser(userName: String, userId: String, profilePicture: String)
}
