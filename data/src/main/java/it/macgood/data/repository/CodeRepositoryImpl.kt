package it.macgood.data.repository

import it.macgood.data.database.CodeDao
import it.macgood.domain.model.AlgorithmImpl
import it.macgood.domain.model.AlgorithmName
import it.macgood.domain.repository.CodeRepository
import it.macgood.data.database.mapper.toAlgorithmListName
import it.macgood.data.database.mapper.toAlgorithmImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CodeRepositoryImpl @Inject constructor(
    private val dao: CodeDao
) : CodeRepository {
    override fun getAllAlgorithms(): Flow<List<AlgorithmName>> = dao.getAllAlgorithms().map { it.toAlgorithmListName() }

    override suspend fun getAlgorithmImpl(id: Long): AlgorithmImpl = withContext(Dispatchers.IO) {
        dao.getAlgorithmImpl(id).toAlgorithmImpl()
    }
}

