package com.lesa.countries.countries.presentation.countries_list.models

data class CountryUi(
    val commonName: String,
    val officialName: String,
    val capital: String,
    val region: String,
    val subregion: String,
    val flagEmoji: String,
    val flagSvgUrl: String? = null,
)

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
