package com.lesa.countries.countries.presentation.countries_list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import coil3.compose.SubcomposeAsyncImage
import com.lesa.core.presentation.ViewScale
import com.lesa.countries.R
import com.lesa.countries.countries.presentation.countries_list.models.CountryUi
import com.lesa.countries.countries.presentation.countries_list.models.countryUiSample
import com.lesa.countries.ui.theme.CountriesTheme

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
                CircularProgressIndicator()
            },
            error = {
                Icon(
                    painter = painterResource(R.drawable.sad_face),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.error
                )
            },
            modifier = Modifier
                .size(scale.flagSize)
                .clip(CircleShape)
                .border(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.onBackground,
                    shape = CircleShape
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
