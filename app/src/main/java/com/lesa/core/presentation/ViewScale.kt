package com.lesa.core.presentation

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

enum class ViewScale(
    val flagSize: Dp,
    val titleTextSize: TextUnit,
    val descriptionTextSize: TextUnit,
) {
    LARGE(
        flagSize = 96.dp,
        titleTextSize = 24.sp,
        descriptionTextSize = 16.sp,
    ),
    MEDIUM(
        flagSize = 64.dp,
        titleTextSize = 20.sp,
        descriptionTextSize = 14.sp,
    ),
    SMALL(
        flagSize = 48.dp,
        titleTextSize = 16.sp,
        descriptionTextSize = 12.sp,
    ),
}
