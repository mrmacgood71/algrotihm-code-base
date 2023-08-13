package it.macgood.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import it.macgood.core.CustomTransition
import it.macgood.algorithms.AlgorithmsScreen
import it.macgood.algorithmimpl.AlgorithmImplementationScreen

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AlgorithmNavigation() {
    val navController = rememberAnimatedNavController()
    AnimatedNavHost(navController = navController, startDestination = Screen.AlgorithmScreen.route) {
        composable(
            route = Screen.AlgorithmScreen.route,
            arguments = Screen.AlgorithmScreen.arguments,
            enterTransition = { CustomTransition.enterTransition() },
            exitTransition = { CustomTransition.exitTransition() },
            popEnterTransition = { CustomTransition.popEnterTransition() },
            popExitTransition = { CustomTransition.popExitTransition() }
        ) {
            AlgorithmsScreen(
                navRoute = Screen.ImplementationScreen.route,
                navController = navController
            )
        }

        composable(
            route = "${Screen.ImplementationScreen.route}/{${Screen.ALGORITHM_ID}}",
            arguments = Screen.ImplementationScreen.arguments,
            enterTransition = { CustomTransition.enterTransition() },
            exitTransition = { CustomTransition.exitTransition() },
            popEnterTransition = { CustomTransition.popEnterTransition() },
            popExitTransition = { CustomTransition.popExitTransition() }
        ) {
            AlgorithmImplementationScreen(navController = navController)
        }
    }
}

