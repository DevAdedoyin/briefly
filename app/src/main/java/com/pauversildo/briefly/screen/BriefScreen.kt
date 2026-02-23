package com.pauversildo.briefly.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pauversildo.briefly.components.BrieflyInputTextField
import com.pauversildo.briefly.components.BrieflySubmitButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BriefScreen() {
    var title by remember {
        mutableStateOf("")
    }
    var description by remember {
        mutableStateOf("")
    }
    Column(modifier = Modifier.padding(6.dp)) {
        TopAppBar(
            title = { Text("Briefly") },
            actions = {},
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.Blue, titleContentColor = Color.White
            )
        )

//         Column
        Column(
            modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            BrieflyInputTextField(
                modifier = Modifier.padding(top = 9.dp, bottom = 8.dp),
                text = title,
                label = title,
                maxLine = 1,
                onTextChange = {
                    if (it.all { char ->
                            char.isLetter() || char.isWhitespace()
                        })
                        title = it
                },
                onImeAction = {})
            BrieflyInputTextField(
                modifier = Modifier.padding(top = 9.dp, bottom = 8.dp),
                text = description,
                label = "Add a note",
                maxLine = 1,
                onTextChange = {
                    if (it.all { char ->
                            char.isLetter() || char.isWhitespace()
                        })
                        description = it
                },
                onImeAction = {})
            BrieflySubmitButton(text = "Save", onClick = {})
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BriefScreenPreview() {
    BriefScreen()
}