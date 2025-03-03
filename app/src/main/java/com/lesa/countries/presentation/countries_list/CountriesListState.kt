package com.lesa.countries.presentation.countries_list

import androidx.compose.runtime.Immutable
import com.lesa.countries.presentation.models.CountryUi

@Immutable
data class CountriesListState(
    val isLoading: Boolean = false,
    val countries: List<CountryUi> = emptyList(),
    val selectedCountry: CountryUi? = null,
)
