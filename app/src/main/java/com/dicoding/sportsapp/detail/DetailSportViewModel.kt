package com.dicoding.sportsapp.detail

import androidx.lifecycle.ViewModel
import com.dicoding.core.data.Sport
import com.dicoding.core.domain.SportUseCase

class DetailSportViewModel(private val sportUseCase: SportUseCase) : ViewModel() {
    fun setFavoriteTourism(tourism: Sport, newStatus:Boolean) =
        sportUseCase.setFavoriteTourism(tourism, newStatus)
}