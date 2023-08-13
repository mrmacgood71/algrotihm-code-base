package it.macgood.algorithmimpl

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import it.macgood.domain.usecase.GetAlgorithmImplUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AlgorithmImplViewModel @Inject constructor(
    private val getAlgorithmImplUseCase: GetAlgorithmImplUseCase,
    algorithmId: String,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _implementation = MutableStateFlow<AlgorithmImplState>(AlgorithmImplState.IsLoading)
    val impl: StateFlow<AlgorithmImplState> = _implementation

    init {
        val id = savedStateHandle.get<Long>(algorithmId)
        if (id != null) {
            loadAlgorithmImplementation(id)
        } else {
            loadAsError()
        }
    }

    private fun loadAsError() = _implementation.update { AlgorithmImplState.Error(R.string.error_not_exists) }


    private fun loadAlgorithmImplementation(id: Long) {
        viewModelScope.launch {
            getAlgorithmImplUseCase(id)
                .onSuccess { algorithm ->
                    _implementation.update { AlgorithmImplState.Algorithm(algorithm) }
                }.onFailure {
                    _implementation.update { AlgorithmImplState.Error(R.string.error_unexpected) }
                }
        }
    }
}