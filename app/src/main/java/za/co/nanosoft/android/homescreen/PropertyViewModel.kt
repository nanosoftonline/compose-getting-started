package za.co.nanosoft.android.homescreen

import za.co.nanosoft.android.homescreen.data.PropertyRepository
import za.co.nanosoft.android.homescreen.data.PropertyUiState


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import za.co.nanosoft.android.homescreen.data.Property_API_Repository

class PropertyViewModel : ViewModel() {
    private val repository = Property_API_Repository()
    private val _uiState = MutableStateFlow<PropertyUiState>(PropertyUiState.Loading)
    val uiState: StateFlow<PropertyUiState> = _uiState

    init {
        fetchProperties()
    }

    private fun fetchProperties() {
        viewModelScope.launch {
            try {
                val properties = repository.fetchProperties()
                _uiState.value = PropertyUiState.Success(properties)
            } catch (e: Exception) {
                _uiState.value = PropertyUiState.Error("Failed to load properties")
            }
        }
    }
}
