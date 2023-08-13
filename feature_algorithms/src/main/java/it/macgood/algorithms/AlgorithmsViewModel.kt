package it.macgood.algorithms

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import it.macgood.domain.model.AlgorithmName
import it.macgood.domain.usecase.GetAlgorithmsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AlgorithmsViewModel @Inject constructor(
    private val getAlgorithmsUseCase: GetAlgorithmsUseCase
) : ViewModel() {

    private val _algorithms = MutableStateFlow<List<AlgorithmName>>(listOf())
    val algorithms: StateFlow<List<AlgorithmName>> = _algorithms

    init {
        getAlgorithms()
    }

    private fun getAlgorithms() {
        viewModelScope.launch {
            getAlgorithmsUseCase().onSuccess {
                it.collect {list ->
                    _algorithms.update { list }
                }
            }
        }
    }


}