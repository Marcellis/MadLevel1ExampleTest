package com.example.madlevel1example

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.madlevel1example.ui.theme.MadLevel1ExampleTheme
import androidx.compose.material.OutlinedTextField as OutlinedTextField

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MadLevel1ExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    GuessAnimalScreen()
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun GuessAnimalScreen() {
    Scaffold(
        topBar = { TopAppBar(
            title = { Text(text = stringResource(id = R.string.app_name)) }
        )
        },
        content = { ScreenContent() }
    )
}

@Composable
fun ScreenContent() {

    // Local variable to hold and save the value of the text entered by the user.
    var answerText by remember { mutableStateOf(String()) }

    Column(
        Modifier
            .fillMaxHeight()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            modifier = Modifier.padding(top = 20.dp),
            text = stringResource(R.string.animal_question),
            style = MaterialTheme.typography.h6,
        )
        Image(
            painter = painterResource(id = R.drawable.giraffe),
            contentDescription = "", // decorative element
            modifier = Modifier
                .padding (all = 16.dp)
                .width(250.dp)
                .height(250.dp)
        )
        Row() {
            OutlinedTextField(
                value = answerText,
                // Below line is used to add placeholder ("hint") for our text field.
                placeholder = { Text(text = stringResource(id = R.string.animal_question)) },
                onValueChange = {
                                answerText = it
                },
                label = { Text(stringResource(R.string.answer_label)) }
            )
            Button(
                modifier = Modifier.padding(start = 24.dp, top = 12.dp),
                onClick = {
                    // TODO To be completed
                }
            ) {
                Icon(Icons.Filled.Send, "Process user input")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MadLevel1ExampleTheme {
        GuessAnimalScreen()
    }
}