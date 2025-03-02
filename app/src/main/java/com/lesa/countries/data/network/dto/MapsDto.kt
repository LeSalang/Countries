package com.lesa.countries.data.network.dto

import kotlinx.serialization.Serializable

@Serializable
data class MapsDto(
    val googleMaps: String,
    val openStreetMaps: String,
)
