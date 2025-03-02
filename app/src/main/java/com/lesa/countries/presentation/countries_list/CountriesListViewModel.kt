package com.lesa.countries.presentation.countries_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lesa.core.domain.util.onError
import com.lesa.core.domain.util.onSuccess
import com.lesa.countries.domain.CountryDataSource
import com.lesa.countries.presentation.countries_list.models.toCountryUi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CountriesListViewModel(
    private val countryDataSource: CountryDataSource,
) : ViewModel() {
    private val _state = MutableStateFlow(CountriesListState())
    val state = _state
        .onStart { loadCountries() }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = CountriesListState()
        )

    private fun loadCountries() {
        viewModelScope.launch {
            _state.update { state ->
                state.copy(
                    isLoading = true
                )
            }
            countryDataSource
                .getCountries()
                .onSuccess { countries ->
                    _state.update { state ->
                        state.copy(
                            isLoading = false,
                            countries = countries.map { country -> country.toCountryUi() },
                        )
                    }
                }
                .onError {
                    _state.update { state ->
                        state.copy(
                            isLoading = false,
                        )
                    }
                }
        }
    }
}
