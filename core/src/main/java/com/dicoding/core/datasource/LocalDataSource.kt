package com.dicoding.core.datasource

import com.dicoding.core.SportDao
import com.dicoding.core.data.SportEntity
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val tourismDao: SportDao) {

    fun getAllTourism(): Flow<List<SportEntity>> = tourismDao.getAllTourism()

    fun getFavoriteTourism(): Flow<List<SportEntity>> = tourismDao.getFavoriteTourism()

    suspend fun insertTourism(tourismList: List<SportEntity>) = tourismDao.insertTourism(tourismList)

    fun setFavoriteTourism(tourism: SportEntity, newState: Boolean) {
        tourism.isFavorite = newState
        tourismDao.updateFavoriteTourism(tourism)
    }
}