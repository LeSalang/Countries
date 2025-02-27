package com.lesa.countries.countries.presentation.countries_list

import androidx.compose.runtime.Immutable
import com.lesa.countries.countries.presentation.countries_list.models.CountryUi

@Immutable
data class CountriesListState(
    val isLoading: Boolean = false,
    val countries: List<CountryUi> = emptyList(),
    val selectedCountry: CountryUi? = null,
)
