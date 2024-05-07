package com.example.m5_hw2.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.m5_hw2.data.local.entities.History

@Dao
interface LoveDao {

    @Insert
    fun addHistory(history: History)

    @Query("SELECT * FROM histories ORDER BY first_name ASC")
    fun getHistoriesSortedByFirstName(): LiveData<List<History>>

    @Query("SELECT * FROM histories")
    suspend fun getAllHistory(): List<History>

    @Query("DELETE FROM histories WHERE id = :historyId")
    fun deleteHistory(historyId: Int)
}
