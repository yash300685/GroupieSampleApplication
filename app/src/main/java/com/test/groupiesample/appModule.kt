package com.test.groupiesample

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appMopdule= module {
    single<Repository> { RepositoryImpl(get()) }
    viewModel { TVViewModel(get())}
}