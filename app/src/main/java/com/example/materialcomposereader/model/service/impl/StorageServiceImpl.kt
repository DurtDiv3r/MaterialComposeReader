package com.example.materialcomposereader.model.service.impl

import com.example.materialcomposereader.model.User
import com.example.materialcomposereader.model.service.StorageService
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class StorageServiceImpl
@Inject
constructor(private val firestore: FirebaseFirestore) :
    StorageService {
    override suspend fun saveUser(userName: String, userId: String, profilePicture: String) {
        val user = User(
            userId = userId,
            userName = userName,
            profilePicture = profilePicture,
        ).toUserMap()

        firestore.collection("users").add(user).await()
    }
}
