package com.lesa.core.presentation.util

import android.content.Context
import com.lesa.core.domain.util.NetworkError
import com.lesa.countries.R

fun NetworkError.toString(context: Context): String {
    val resId = when (this) {
        NetworkError.NO_INTERNET_CONNECTION -> R.string.error_no_internet_connection
        NetworkError.REQUEST_TIMEOUT -> R.string.error_request_timeout
        NetworkError.SERIALIZATION_ERROR -> R.string.error_serialization_error
        NetworkError.SERVER_ERROR -> R.string.error_server_error
        NetworkError.TOO_MANY_REQUESTS -> R.string.error_too_many_requests
        NetworkError.UNKNOWN_ERROR -> R.string.error_unknown_error
    }
    return context.getString(resId)
}
