package com.example.materialcomposereader.model

data class User(
    val userId: String,
    val userName: String,
    val profilePicture: String,
) {
    fun toUserMap(): Map<String, Any> {
        return mapOf(
            "user_id" to this.userId,
            "user_name" to this.userName,
            "profile_picture" to this.profilePicture,
        )
    }
}
