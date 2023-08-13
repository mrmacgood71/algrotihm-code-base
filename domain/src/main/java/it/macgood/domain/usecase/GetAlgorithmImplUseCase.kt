package it.macgood.domain.usecase

import it.macgood.domain.repository.CodeRepository
import javax.inject.Inject

class GetAlgorithmImplUseCase @Inject constructor(
    private val repository: CodeRepository
) {

    suspend operator fun invoke(id: Long) = kotlin.runCatching { repository.getAlgorithmImpl(id) }

}
