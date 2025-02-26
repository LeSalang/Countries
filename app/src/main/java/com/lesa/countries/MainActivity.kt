package com.lesa.countries

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.lesa.countries.countries.presentation.countries_list.components.CountriesListItem
import com.lesa.countries.countries.presentation.countries_list.models.countryUiSample
import com.lesa.countries.ui.theme.CountriesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CountriesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CountriesListItem(
                        countryUi = countryUiSample,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
