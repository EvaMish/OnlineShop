package com.example.onlineshopwb.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Users::class], version = 1)
abstract class AppDB : RoomDatabase() {
    abstract val dao: UserDao

    companion object {
        fun createDataBase(context: Context): AppDB {
            return Room.databaseBuilder(
                context,
                AppDB::class.java,
                "wb.db"

            ).fallbackToDestructiveMigration().build()
        }
    }
}