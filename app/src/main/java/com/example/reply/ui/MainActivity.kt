/*
 * Copyright 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.reply.ui

import android.content.res.Configuration
import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.reply.data.LocalEmailsDataProvider
import com.example.reply.ui.theme.AppTheme
import java.lang.reflect.Modifier


class MainActivity : ComponentActivity() {

    private val viewModel: ReplyHomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val uiState by viewModel.uiState.collectAsState()
            AppTheme {
                Surface(tonalElevation = 5.dp) {
                    ReplyApp(uiState)
                }
            }
        }
    }
}

@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "DefaultPreviewDark"
)
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    name = "DefaultPreviewLight"
)
@Composable
fun ReplyAppPreview() {
    AppTheme {
        ReplyApp(
            replyHomeUIState = ReplyHomeUIState(
                emails = LocalEmailsDataProvider.allEmails
            )
        )
    }
}

@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    name = "DefaultPreviewLight"
)
@Composable
fun ChatMessagePreview() {
    AppTheme {
        Column (){
            var showMore by rememberSaveable { mutableStateOf(false) }
            Text(
                text = "My Text Chat App",
                style = MaterialTheme.typography.bodyLarge
                    .copy(color = MaterialTheme.colorScheme.primary),
            )
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Send")
            }

            Text(
                text = "My Text Chat App dsnlkdsnsa lkdsanldskndas" +
                        "dsalkdsaksa" +
                        " dsaksalksdlkdsa" +
                        "dsak dsalkndskdsa" +
                        " dsakdsalkdsalkdsa" +
                        " dsakdsalkdsa'lsakdsa" +
                        " mdsa ldsa'dsa'lmdsa" +
                        " dsalk sadlk dsalkdsa " +
                        " salmdsa;ldsam;dsalmdsa" +
                        " dsa;lmdsal;dsa",
                style = MaterialTheme.typography.bodyLarge.copy(color = MaterialTheme.colorScheme.primary),
                maxLines = 5,
                overflow = TextOverflow.Ellipsis,
                onTextLayout = {
                    if(it.hasVisualOverflow){
                        // show Button...//
                        showMore = true
                    }
                }

            )

            if(showMore){
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "More")
                }
            }

        }
    }
}

