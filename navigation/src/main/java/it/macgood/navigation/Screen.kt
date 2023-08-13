package it.macgood.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class Screen(
    val route: String, val arguments: List<NamedNavArgument>
) {
    object AlgorithmScreen : Screen("algorithm_screen", emptyList())
    object ImplementationScreen : Screen("impl_screen", listOf(
        navArgument(
            name = ALGORITHM_ID
        ) {
            type = NavType.LongType
        }
    ))

    companion object {
        const val ALGORITHM_ID = "algorithm_id"
    }
}