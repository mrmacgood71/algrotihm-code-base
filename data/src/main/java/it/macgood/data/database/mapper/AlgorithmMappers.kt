package it.macgood.data.database.mapper

import it.macgood.data.entity.Algorithm
import it.macgood.domain.model.AlgorithmImpl
import it.macgood.domain.model.AlgorithmName

fun Algorithm.toAlgorithmImpl() = AlgorithmImpl(id, name, description, cppImpl, pythonImpl, javaImpl)


fun Algorithm.toAlgorithmName() = AlgorithmName(
    id = id,
    name = name,
    description = description
)

fun List<Algorithm>.toAlgorithmListName(): List<AlgorithmName> = this.map { it.toAlgorithmName() }