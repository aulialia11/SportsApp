package com.dicoding.favorite

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val favoritviewModelModule = module {
    viewModel { FavoriteViewModel(get()) }
}
