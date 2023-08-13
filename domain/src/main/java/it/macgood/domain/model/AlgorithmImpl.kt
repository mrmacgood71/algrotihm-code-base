package it.macgood.domain.model

data class AlgorithmImpl(
    val id: Long = 0,
    val name: String = "",
    val description: String = "",
    val cppImpl: String = "",
    val pythonImpl: String = "",
    val javaImpl: String = ""
)

