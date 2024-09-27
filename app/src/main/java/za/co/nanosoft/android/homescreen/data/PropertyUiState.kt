package za.co.nanosoft.android.homescreen.data

import Property

sealed class PropertyUiState {
    data object Loading : PropertyUiState()                     // Represents the loading state
    data class Success(val properties: List<Property>) : PropertyUiState()  // Represents a successful data fetch
    data class Error(val message: String) : PropertyUiState() // Represents an error state with an error message
}
