package com.pauversildo.briefly.screen

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pauversildo.briefly.components.BrieflyInputTextField
import com.pauversildo.briefly.components.BrieflySubmitButton
import com.pauversildo.briefly.data.BriefDataSource
import com.pauversildo.briefly.model.Brief
import java.time.format.DateTimeFormatter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BriefScreen(briefs: List<Brief>, onAddBrief: (Brief) -> Unit, onRemoveBrief: (Brief) -> Unit) {
    var title by remember {
        mutableStateOf("")
    }
    var description by remember {
        mutableStateOf("")
    }
    val context = LocalContext.current
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
                label = "Title",
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
            BrieflySubmitButton(text = "Save", onClick = {
                if (title.isNotEmpty() && description.isNotEmpty()) {
                    onAddBrief(Brief(title = title, description = description))
                    title = ""
                    description = ""
                    Toast.makeText(context, "Note Added", Toast.LENGTH_SHORT).show()
                }
            })
        }

        HorizontalDivider(
            modifier = Modifier.padding(10.dp),
        )
        LazyColumn {
            items(briefs) { brief ->
                BriefRow(brief = brief, onBriefClicked = {
                    onRemoveBrief(brief)
                })
            }
        }
    }
}

@Composable
fun BriefRow(modifier: Modifier = Modifier, brief: Brief, onBriefClicked: (Brief) -> Unit) {

    Surface(
        modifier
            .padding(4.dp)
            .clip(RoundedCornerShape(topEnd = 33.dp, bottomStart = 33.dp))
            .fillMaxWidth(),
        color = Color(0xFFDFE6EB),
        tonalElevation = 6.dp
    ) {
        Column(
            modifier
                .clickable {onBriefClicked(brief)}
                .padding(horizontal = 14.dp, vertical = 6.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(text = brief.title, style = MaterialTheme.typography.titleMedium)
            Text(text = brief.description, style = MaterialTheme.typography.titleMedium)
            Text(
                text = brief.entryDate.format(DateTimeFormatter.ofPattern("EEE, d MMM")),
                style = MaterialTheme.typography.titleSmall
            )

        }
    }

}

@Preview(showBackground = true)
@Composable
fun BriefScreenPreview() {
    BriefScreen(
        briefs = BriefDataSource().loadBriefs(),
        onAddBrief = { },
        onRemoveBrief = { }
    )
}