package com.dicoding.maps

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.core.domain.SportUseCase

class MapsViewModel(tourismUseCase: SportUseCase) : ViewModel() {
    val tourism = tourismUseCase.getAllTourism().asLiveData()
}
