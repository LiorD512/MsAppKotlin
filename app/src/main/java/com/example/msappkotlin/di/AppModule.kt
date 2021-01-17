package com.example.msappkotlin.di

import com.example.msappkotlin.data.MovieRepository
import com.example.msappkotlin.features.main.MoviesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single { MovieRepository(get()) }

    viewModel { MoviesViewModel(get()) }
}