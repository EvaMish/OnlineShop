package com.example.onlineshopwb.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class Users(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val userName: String,
    val userSurname: String,
    val userPhoneNumber: String
)