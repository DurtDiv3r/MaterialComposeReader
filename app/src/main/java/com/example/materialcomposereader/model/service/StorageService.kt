package com.example.materialcomposereader.model.service

interface StorageService {
    suspend fun saveUser(userData: Map<String, Any>)
}
