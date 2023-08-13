package it.macgood.domain.usecase

import it.macgood.domain.repository.CodeRepository
import javax.inject.Inject

class GetAlgorithmsUseCase @Inject constructor(
    private val repository: CodeRepository
) {

    operator fun invoke() = kotlin.runCatching { repository.getAllAlgorithms() }
}