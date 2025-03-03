package com.lesa.countries.data.network

import com.lesa.core.data.network.constructUrl
import com.lesa.core.data.network.safeCall
import com.lesa.core.domain.util.NetworkError
import com.lesa.core.domain.util.Result
import com.lesa.core.domain.util.map
import com.lesa.countries.data.network.dto.CountryDto
import com.lesa.countries.data.network.dto.toCountry
import com.lesa.countries.domain.CountryDataSource
import com.lesa.countries.domain.models.Country
import io.ktor.client.HttpClient
import io.ktor.client.request.get

class RemoteCountryDataSource(
    private val httpClient: HttpClient,
) : CountryDataSource {
    override suspend fun getCountries(): Result<List<Country>, NetworkError> {
        return safeCall<List<CountryDto>> {
            httpClient.get(
                urlString = constructUrl(url = "all")
            )
        }.map { response ->
            response.map { it.toCountry() }
        }
    }
}
