package it.macgood.algorithmimpl

import it.macgood.domain.model.AlgorithmImpl


sealed class AlgorithmImplState {
    data class Algorithm(val value: AlgorithmImpl) : AlgorithmImplState()
    object IsLoading : AlgorithmImplState()
    data class Error(val value: Int?): AlgorithmImplState()

}