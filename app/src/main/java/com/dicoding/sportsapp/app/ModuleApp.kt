package com.dicoding.sportsapp.app

import com.dicoding.core.domain.SportInteractor
import com.dicoding.core.domain.SportUseCase
import com.dicoding.sportsapp.detail.DetailSportViewModel
import com.dicoding.sportsapp.home.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<SportUseCase> { SportInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { DetailSportViewModel(get()) }
}