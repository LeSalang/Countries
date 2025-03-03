package com.lesa.countries.presentation.countries_list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import coil3.compose.SubcomposeAsyncImage
import com.lesa.core.presentation.util.ViewScale
import com.lesa.countries.R
import com.lesa.countries.presentation.models.CountryUi
import com.lesa.countries.presentation.models.countryUiSample
import com.lesa.core.presentation.ui.theme.CountriesTheme

@Composable
fun CountriesListItem(
    countryUi: CountryUi,
    scale: ViewScale = ViewScale.MEDIUM,
    modifier: Modifier = Modifier,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
            .padding(16.dp)
    ) {
        SubcomposeAsyncImage(
            model = countryUi.flagSvgUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            loading = {
                LinearProgressIndicator(
                    modifier = Modifier
                        .width(scale.flagWidth)
                        .padding(8.dp)
                )
            },
            error = {
                Icon(
                    painter = painterResource(R.drawable.ic_error),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.error
                )
            },
            modifier = Modifier
                .width(scale.flagWidth)
                .border(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.onBackground,
                    shape = RectangleShape
                )
        )
        Column {
            Text(
                text = countryUi.commonName.uppercase(),
                fontSize = scale.titleTextSize,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground,
            )
            Text(
                text = countryUi.officialName,
                fontSize = scale.descriptionTextSize,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.onBackground,
            )
            if (!countryUi.subregion.isNullOrBlank()) {
                Text(
                    text = countryUi.subregion,
                    fontSize = scale.descriptionTextSize,
                    fontWeight = FontWeight.Light,
                    fontStyle = FontStyle.Italic,
                    color = MaterialTheme.colorScheme.onBackground,
                )
            }
        }
    }
}

@PreviewLightDark
@Composable
private fun CountriesListItemPreview() {
    CountriesTheme {
        CountriesListItem(
            countryUi = countryUiSample,
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
        )
    }
}
