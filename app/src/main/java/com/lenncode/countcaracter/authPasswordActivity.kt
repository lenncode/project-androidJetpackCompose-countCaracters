package com.lenncode.countcaracter

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun LoginPasswordPage() {
    val usersPrincipal = HashMap<String, String>()
    usersPrincipal["sam"] = "A1B2C3D4E5"
    usersPrincipal["lenncode"] = "12345678"
    usersPrincipal["charlott123"] = "zxcvbnmz"

    //now we will create the two varaible for email and password
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }

    //first we will create a column for the layout
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    listOf(
                        Color(
                            0xFFFF4880
                        ), Color(0xFFE500FF)
                    )
                )
            ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Email", modifier = Modifier.padding(start = 25.dp))

        TextField(
            value = email,
            onValueChange = { email = it },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,

            )


        Text(text = "Password", modifier = Modifier.padding(start = 25.dp))
        TextField(
            value = password,
            onValueChange = { password = it },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true

        )
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Hazme Click bebe")
        }
    }
    fun validationEmailExists() {
        if(email.equals(usersPrincipal["sam"])){

        }
    }
}