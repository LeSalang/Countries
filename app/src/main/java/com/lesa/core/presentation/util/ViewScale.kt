package com.lesa.core.presentation.util

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

enum class ViewScale(
    val flagWidth: Dp,
    val titleTextSize: TextUnit,
    val descriptionTextSize: TextUnit,
) {
    LARGE(
        flagWidth = 128.dp,
        titleTextSize = 24.sp,
        descriptionTextSize = 16.sp,
    ),
    MEDIUM(
        flagWidth = 96.dp,
        titleTextSize = 20.sp,
        descriptionTextSize = 14.sp,
    ),
    SMALL(
        flagWidth = 80.dp,
        titleTextSize = 14.sp,
        descriptionTextSize = 12.sp,
    ),
}
