package com.lesa.countries.domain.models

data class Country(
    val commonName: String,
    val officialName: String,
    val cca2: String,
    val cca3: String,
    val capital: List<String>?,
    val continents: List<String>,
    val region: String,
    val subregion: String?,
    val flagEmoji: String,
    val flagSvgUrl: String,
)
