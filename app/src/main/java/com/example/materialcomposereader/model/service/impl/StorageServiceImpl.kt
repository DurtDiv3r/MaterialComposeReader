package com.example.materialcomposereader.model.service.impl

import com.example.materialcomposereader.model.service.StorageService
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class StorageServiceImpl
@Inject
constructor(private val firestore: FirebaseFirestore) :
    StorageService {
    override suspend fun saveUser(userData: Map<String, Any>) {
        firestore.collection("users").add(userData).await()
    }
}
