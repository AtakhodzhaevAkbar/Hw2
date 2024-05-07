package com.example.m5_hw2.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.m5_hw2.data.local.dao.LoveDao
import com.example.m5_hw2.data.local.entities.History

@Database(entities = [History::class], version = 1, exportSchema = false)
abstract class LoveDataBase : RoomDatabase() {
    abstract fun dao(): LoveDao

    companion object {
        @Volatile
        private var INSTANCE: LoveDataBase? = null

        fun getInstance(context: Context): LoveDataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    LoveDataBase::class.java,
                    "love_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
