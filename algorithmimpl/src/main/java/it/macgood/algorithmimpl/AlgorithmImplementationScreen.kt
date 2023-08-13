package it.macgood.algorithmimpl

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import it.macgood.algorithmimpl.component.ImplementationCard
import it.macgood.domain.model.AlgorithmImpl

@Composable
fun AlgorithmImplementationScreen(
    navController: NavController,
    implViewModel: AlgorithmImplViewModel = hiltViewModel()
) {
    val algorithmImpl = implViewModel.impl.collectAsState().value

    when(algorithmImpl) {
        is AlgorithmImplState.Algorithm -> {
            DetailsScreen(algorithmImpl.value, navController)
        }
        is AlgorithmImplState.Error -> {
            Text(
                modifier = Modifier.fillMaxSize(),
                text = stringResource(id = algorithmImpl.value ?: R.string.error_unexpected)
            )
        }
        AlgorithmImplState.IsLoading -> {
            CircularProgressIndicator(Modifier.fillMaxSize())
        }
    }
}

@Composable
private fun DetailsScreen(
    algorithmImpl: AlgorithmImpl,
    navController: NavController
) {
    val scrollableState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollableState),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {

        TopTitle(algorithmImpl.name, navController)

        Text(
            text = algorithmImpl.description
        )

        ImplementationCard(
            leadingText = stringResource(id = R.string.cpp_implementation),
            text = algorithmImpl.cppImpl
        )

        ImplementationCard(
            leadingText = stringResource(id = R.string.python_implementation),
            text = algorithmImpl.pythonImpl
        )

        ImplementationCard(
            leadingText = stringResource(id = R.string.java_implementation),
            text = algorithmImpl.javaImpl
        )

    }
}

@Composable
private fun TopTitle(
    title: String,
    navController: NavController
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = title, fontSize = 32.sp)
        Text(
            modifier = Modifier.clickable { navController.navigateUp() },
            text = stringResource(R.string.back),
            textDecoration = TextDecoration.Underline,
            color = Color.Gray
        )
    }
}

