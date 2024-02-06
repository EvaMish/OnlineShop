package com.example.onlineshop.data.db

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface Dao {
    @Insert
    suspend fun insertUser(user:User)

}