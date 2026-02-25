package com.pauversildo.briefly

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pauversildo.briefly.data.BriefDataSource
import com.pauversildo.briefly.model.Brief
import com.pauversildo.briefly.screen.BriefScreen
import com.pauversildo.briefly.screen.BriefViewModel
import com.pauversildo.briefly.ui.theme.BrieflyTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlin.getValue

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainApp() {
                Surface(color = MaterialTheme.colorScheme.background) {
                    val briefViewModel: BriefViewModel by viewModels()
                    BriefApp(briefViewModel)
                }
            }
        }
    }
}

@Composable
fun BriefApp(briefViewModel: BriefViewModel = viewModel()) {
    val briefList = briefViewModel.getAllBriefs()

    BriefScreen(
        briefs = briefList,
        onAddBrief = {
            briefViewModel.addBrief(it)
        },
        onRemoveBrief = {
            briefViewModel.removeBrief(it)
        })
}

@Composable
fun MainApp(content: @Composable () -> Unit) {
    BrieflyTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                content()
            }
        }
    }
}
