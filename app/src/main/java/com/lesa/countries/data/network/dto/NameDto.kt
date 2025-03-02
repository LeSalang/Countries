package com.lesa.countries.data.network.dto

import kotlinx.serialization.Serializable

@Serializable
data class NameDto(
    val common: String,
    val official: String,
)
