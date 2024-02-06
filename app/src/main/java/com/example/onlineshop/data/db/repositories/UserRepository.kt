package com.example.onlineshop.data.db.repositories

import com.example.onlineshop.data.db.Dao
import com.example.onlineshop.data.db.User

class UserRepository(private val dao: Dao) {
    suspend fun registerUser(user: User){
        dao.insertUser(user)
    }
}