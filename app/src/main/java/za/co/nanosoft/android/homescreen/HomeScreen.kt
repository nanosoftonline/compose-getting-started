package za.co.nanosoft.android.homescreen

import Property
import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import za.co.nanosoft.android.homescreen.data.PropertyUiState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(viewModel: PropertyViewModel = PropertyViewModel()) {
    val uiState by viewModel.uiState.collectAsState()
    val filters =  listOf("All", "Apartments", "Houses", "Villas")
    var selectedFilter by remember { mutableStateOf("All") }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Airbnb") }, actions = {
                Row {
                    Button(onClick = {}) {Text("Save") }
                }
            })
        }
    ){ paddingValues ->
        Box(modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()) {

            when (uiState){
                is PropertyUiState.Error -> {
                    Text(
                        text = (uiState as PropertyUiState.Error).message,
                        modifier = Modifier.align(Alignment.Center),
                        color = MaterialTheme.colorScheme.error
                    )
                }
                PropertyUiState.Loading -> {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }
                is PropertyUiState.Success -> {
                    val properties = (uiState as PropertyUiState.Success).properties
                    Column {
                        SearchBar(
                            placeholder = "Where are you going?",
                            onSearch = Unit
                        )

                        FilterChips(
                            filters = filters,
                            selectedFilter = selectedFilter,
                            onFilterSelected = { filter ->
                                selectedFilter = filter
                            }
                        )
                        LazyColumn {
                            items(properties) { property ->
                                PropertyItem(property)
                            }
                        }
                    }

                }
            }
        }
    }
}

