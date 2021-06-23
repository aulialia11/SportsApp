package com.dicoding.core

import androidx.room.*
import com.dicoding.core.data.SportEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface SportDao {

    @Query("SELECT * FROM sport")
    fun getAllTourism(): Flow<List<SportEntity>>

    @Query("SELECT * FROM sport where isFavorite = 1")
    fun getFavoriteTourism(): Flow<List<SportEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTourism(tourism: List<SportEntity>)

    @Update
    fun updateFavoriteTourism(tourism: SportEntity)
}