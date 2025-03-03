package com.lesa.countries.domain

import com.lesa.core.domain.util.NetworkError
import com.lesa.core.domain.util.Result
import com.lesa.countries.domain.models.Country

interface CountryDataSource {
    suspend fun getCountries(): Result<List<Country>, NetworkError>
}
