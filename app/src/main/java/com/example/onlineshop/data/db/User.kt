package com.example.onlineshop.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("user")
data class User(
    @PrimaryKey(autoGenerate = true)
    val idUser: Int? = null,
    val userName: String,
    val userSurname: String,
    val userPhoneNumber: String
)