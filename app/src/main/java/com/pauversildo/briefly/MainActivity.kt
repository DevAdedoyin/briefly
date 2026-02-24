package com.pauversildo.briefly

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import com.pauversildo.briefly.data.BriefDataSource
import com.pauversildo.briefly.model.Brief
import com.pauversildo.briefly.screen.BriefScreen
import com.pauversildo.briefly.ui.theme.BrieflyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainApp() {
                Surface(color = MaterialTheme.colorScheme.background) {
                    val briefs = remember {
                        mutableStateListOf<Brief>()
                    }

                    BriefScreen(
                        briefs = briefs,
                        onAddBrief = {
                            briefs.add(it)
                        },
                        onRemoveBrief = {
                            briefs.remove(it)
                        })
                }
            }
        }
    }
}

@Composable
fun MainApp(content: @Composable () -> Unit) {
    BrieflyTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Box(modifier = innerPadding as Modifier) {
                content()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BrieflyTheme {
        MainApp() {
            BriefScreen(
                briefs = BriefDataSource().loadBriefs(),
                onAddBrief = { },
                onRemoveBrief = { })
        }
    }
}