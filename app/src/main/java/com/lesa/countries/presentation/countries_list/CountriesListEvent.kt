package com.lesa.countries.presentation.countries_list

import com.lesa.core.domain.util.NetworkError

sealed interface CountriesListEvent {
    data class ErrorEvent(val error: NetworkError): CountriesListEvent
}
