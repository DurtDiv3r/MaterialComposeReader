package com.example.materialcomposereader.model.service.impl

import com.example.materialcomposereader.model.service.LoginService
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class LoginServiceImpl @Inject constructor(private val auth: FirebaseAuth) : LoginService {
    override val currentUserId: String
        get() = auth.currentUser?.uid.orEmpty()

    override suspend fun authenticate(
        email: String,
        password: String,
        route: (Boolean, String) -> Unit,
    ) {
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
            if (it.isSuccessful) {
                route(true, "${it.result?.user?.email} logged in successfully")
            } else {
                route(false, "Login unsuccessful: ${it.exception?.message}")
            }
        }.await()
    }

    override suspend fun createUser(
        userName: String,
        email: String,
        password: String,
        route: (Boolean, String) -> Unit,
    ) {
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
            if (it.isSuccessful) {
                route(true, "User created successfully")
            } else {
                route(false, "Create User Unsuccessful: ${it.result}")
            }
        }.await()
    }

    override suspend fun signOut() {
        auth.signOut()
    }
}
