package com.lesa.countries.presentation.countries_list.models

import com.lesa.countries.domain.models.Country

data class CountryUi(
    val commonName: String,
    val officialName: String,
    val capital: String,
    val region: String,
    val subregion: String,
    val flagEmoji: String,
    val flagSvgUrl: String? = null,
)

fun Country.toCountryUi(): CountryUi {
    return CountryUi(
        commonName = commonName,
        officialName = officialName,
        capital = capital?.firstOrNull() ?: "",
        region = region,
        subregion = subregion ?: "",
        flagEmoji = flagEmoji,
        flagSvgUrl = flagSvgUrl
    )
}

val countryUiSample = CountryUi(
    commonName = "Germany",
    officialName = "Federal Republic of Germany",
    capital = "Berlin",
    region = "Europe",
    subregion = "Western Europe",
    flagEmoji = "🇩🇪",
    flagSvgUrl = "https://flagcdn.com/de.svg"
)

val countriesUiSample = List(100) { countryUiSample}
