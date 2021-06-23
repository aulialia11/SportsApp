package com.dicoding.core.domain

import com.dicoding.core.data.Sport


class SportInteractor(private val tourismRepository: ISportRepository): SportUseCase {

    override fun getAllTourism() = tourismRepository.getAllTourism()

    override fun getFavoriteTourism() = tourismRepository.getFavoriteTourism()

    override fun setFavoriteTourism(tourism: Sport, state: Boolean) = tourismRepository.setFavoriteTourism(tourism, state)
}