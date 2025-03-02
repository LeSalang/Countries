package com.lesa.countries.data.network.dto

import com.lesa.countries.domain.models.Country
import kotlinx.serialization.Serializable

@Serializable
data class CountryDto(
    val name: NameDto,
    val cca2: String,
    val cca3: String,
    val capital: List<String>? = null,
    val continents: List<String>,
    val region: String,
    val subregion: String? = null,
    val flag: String,
    val flags: FlagsDto,
    val maps: MapsDto,
)

fun CountryDto.toCountry(): Country {
    return Country(
        commonName = name.common,
        officialName = name.official,
        cca2 = cca2,
        cca3 = cca3,
        capital = capital,
        continents = continents,
        region = region,
        subregion = subregion,
        flagEmoji = flag,
        flagSvgUrl = flags.svg,
    )
}
