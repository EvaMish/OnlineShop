package com.example.onlineshop.data.db

import android.app.Application

class App:Application() {
    val database by lazy {
        AppDB.createDataBase(this)
    }
}