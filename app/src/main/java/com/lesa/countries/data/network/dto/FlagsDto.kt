package com.lesa.countries.data.network.dto

import kotlinx.serialization.Serializable

@Serializable
data class FlagsDto(
    val png: String,
    val svg: String,
)
