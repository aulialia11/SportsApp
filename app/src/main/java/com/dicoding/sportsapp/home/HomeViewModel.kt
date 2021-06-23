package com.dicoding.sportsapp.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.core.domain.SportUseCase

class HomeViewModel(tourismUseCase: SportUseCase) : ViewModel() {
    val tourism = tourismUseCase.getAllTourism().asLiveData()
}