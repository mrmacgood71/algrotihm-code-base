package it.macgood.algorithms

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import it.macgood.algorithms.component.AlgorithmItem

@Composable
fun AlgorithmsScreen(
    navRoute: String,
    navController: NavController,
    viewModel: AlgorithmsViewModel = hiltViewModel()
) {
    val algorithms = viewModel.algorithms.collectAsState().value

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            text = stringResource(id = R.string.app_name),
            fontSize = 24.sp
        )
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {

            items(algorithms) { item ->
                AlgorithmItem(item) {
                    navController.navigate(navRoute + "/${item.id}")
                }
            }
        }
    }
}

