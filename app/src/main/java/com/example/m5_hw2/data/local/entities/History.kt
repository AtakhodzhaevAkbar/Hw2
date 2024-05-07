package com.example.m5_hw2.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "histories")
data class History (
    @PrimaryKey
    val id: Int=0,
    @ColumnInfo(name="first_name")
    val firstName: String,
    @ColumnInfo(name="second_name")
    val secondName:String,
    @ColumnInfo(name="percent")
    val percent:String,
    @ColumnInfo(name="result")
    val result:String
)