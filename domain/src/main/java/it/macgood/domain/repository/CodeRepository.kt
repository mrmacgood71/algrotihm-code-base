package it.macgood.domain.repository

import it.macgood.domain.model.AlgorithmImpl
import it.macgood.domain.model.AlgorithmName
import kotlinx.coroutines.flow.Flow

interface CodeRepository {

    fun getAllAlgorithms() : Flow<List<AlgorithmName>>

    suspend fun getAlgorithmImpl(id: Long): AlgorithmImpl

}