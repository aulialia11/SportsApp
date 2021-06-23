package com.dicoding.core

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dicoding.core.data.SportEntity

@Database(entities = [SportEntity::class], version = 1, exportSchema = false)
abstract class SportDatabase : RoomDatabase() {

    abstract fun tourismDao(): SportDao

}