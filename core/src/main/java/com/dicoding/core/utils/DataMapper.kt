package com.dicoding.core.utils

import com.dicoding.core.data.Sport
import com.dicoding.core.data.SportEntity
import com.dicoding.core.response.SportResponse

object DataMapper {
    fun mapResponsesToEntities(input: List<SportResponse>): List<SportEntity> {
        val tourismList = ArrayList<SportEntity>()
        input.map {
            val tourism = SportEntity(
                sportId = it.idSport,
                strSport = it.strSport,
                strFormat = it.strFormat,
                strSportThumb = it.strSportThumb,
                strSportDescription = it.strSportDescription,
                isFavorite = false
            )
            tourismList.add(tourism)
        }
        return tourismList
    }

    fun mapEntitiesToDomain(input: List<SportEntity>): List<Sport> =
        input.map {
            Sport(
                sportId = it.sportId,
                strSport = it.strSport,
                strFormat = it.strFormat,
                strSportThumb = it.strSportThumb,
                strSportDescription = it.strSportDescription,
                isFavorite = it.isFavorite
            )
        }

    fun mapDomainToEntity(input: Sport) = SportEntity(
        sportId = input.sportId,
        strSport = input.strSport,
        strFormat = input.strFormat,
        strSportThumb = input.strSportThumb,
        strSportDescription = input.strSportDescription,
        isFavorite = input.isFavorite
    )
}