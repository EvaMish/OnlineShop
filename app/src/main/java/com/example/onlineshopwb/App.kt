package com.example.onlineshopwb

import android.app.Application
import com.example.onlineshopwb.db.AppDB

class App : Application() {
    val database by lazy{
        AppDB.createDataBase(this)
    }
}