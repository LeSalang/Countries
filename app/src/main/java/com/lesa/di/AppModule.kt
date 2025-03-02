package com.lesa.di

import com.lesa.core.data.network.HttpClientFactory
import com.lesa.countries.data.network.RemoteCountryDataSource
import com.lesa.countries.domain.CountryDataSource
import com.lesa.countries.presentation.countries_list.CountriesListViewModel
import io.ktor.client.engine.cio.CIO
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

val appModule = module {
    single { HttpClientFactory.create(CIO.create()) }
    singleOf(::RemoteCountryDataSource).bind<CountryDataSource>()
    viewModelOf(::CountriesListViewModel)
}
