package com.dicoding.core.domain

import com.dicoding.core.Resource
import com.dicoding.core.data.Sport
import kotlinx.coroutines.flow.Flow

interface SportUseCase {
    fun getAllTourism(): Flow<Resource<List<Sport>>>
    fun getFavoriteTourism(): Flow<List<Sport>>
    fun setFavoriteTourism(tourism: Sport, state: Boolean)
}