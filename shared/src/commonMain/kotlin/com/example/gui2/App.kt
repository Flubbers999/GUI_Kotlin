package com.example.gui2

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource

import gui2.shared.generated.resources.Res
import gui2.shared.generated.resources.compose_multiplatform
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.ui.text.input.PasswordVisualTransformation

@Composable
@Preview
fun App() {
    MaterialTheme {
        Column {
            MockupLogin()

        }
    }
}

@Composable
fun FavProgrammingLang() {
    val inputProgramming = remember { mutableStateOf("") }
    Column {
        TextField(value = inputProgramming.value, onValueChange = {
            inputProgramming.value = it
        })
    }
    Text("Your favourite programming language is ${inputProgramming.value}", fontSize = 24.sp)

}

@Composable
fun Button() {
    val clickedState = remember { mutableStateOf(0) }

    Column {
        Button(
            onClick = { (clickedState.value++) }
        ) {
            Text("Click me")
        }
        Text("the but has been clicked,${clickedState.value}", fontWeight = FontWeight.Bold)
    }
}

@Composable
fun converter() {
    //val feet = 0.305
    val feet = remember { mutableStateOf("") }
    Column {

        OutlinedTextField(value = feet.value, onValueChange = {
            feet.value = it

        })
        val result = (feet.value.toDoubleOrNull() ?: 0.0) / 305

        Text(result.toString())
    }

}

@Composable
fun MockupLogin() {
    val password = remember { mutableStateOf("") }
    val username = remember { mutableStateOf("") }
    val loggedIn = remember { mutableStateOf(false) }

    Column {
        if (loggedIn.value == false) {
            OutlinedTextField(
                value = username.value,
                singleLine = true,
                onValueChange = { username.value = it },
                label = { Text("Username") })
            OutlinedTextField(
                value = password.value,
                singleLine = true,
                visualTransformation = PasswordVisualTransformation(),
                onValueChange = { password.value = it },
                label = { Text("Password") })

            Button(onClick = {
                if (username.value == "John12" && password.value == "Password") {
                    loggedIn.value = true
                }
            }) {
                Text("Login")
            }
            if (loggedIn.value == true) {
                // put the "logged in as.. " message and the logout button
            }

        } else {
            Text("Logged in as ${username.value}")
            Button(onClick = {loggedIn.value = false})
            {
                Text("LogOut")

            }

        }
    }
}
/*
@Composable
fun newMenu() {
    val clickedState = remember {
        mutableStateOf("Not Clicked")
        Text("Logged in as John12")
        Column {
            Button(
                onClick = { clickedState.value = "Clicked" }
            )
        }
        if clickedState.value == "Clicked"
        Text("Logg Out")


    }
}
 */
