package com.lenncode.countcaracter

import android.R
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.*

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun textFieldEmail() {
    val usersPrincipal = HashMap<String, String>()
    usersPrincipal["sam"] = "A1B2C3D4E5"
    usersPrincipal["lenncode"] = "12345678"
    usersPrincipal["charlott123"] = "zxcvbnmz"


    val ctx = LocalContext.current
    //now we will create the two varaible for email and password
    var email by remember {
        mutableStateOf("")
    }

    val regex = Regex("[a-zA-Z0-9]+")
    val regexClickButton = Regex("[a-zA-Z0-9]{4,21}")
    var error by remember {
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
            placeholder = { Text(text = "Email or user") },
            value = email,
            onValueChange = { text: String ->

                error = if (regex.matches(text)) {
                    ""
                } else {
                    "La cadena debe contener letras y  números."
                }

                email = text
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(50.dp),
            singleLine = true,
        )
        if (error.isNotEmpty()) {
            Text(error, style = TextStyle(color = Color.Red))
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = {
            if(!regexClickButton.matches(email)){
                error = "La cadena debe contener al menos una letra y un" +
                        " número, y tener un tamaño entre 0 y 20 caracteres."
                return@Button

            }
            showAlertDontExistUser(usersPrincipal, email, ctx)
        }) {
            Text(
                text = "Login",
                color = Color.White,
            )
        }
        TextCreditsLenncodexd()
    }
}

@Composable
fun TextCreditsLenncodexd() {
    Text(text = "Created by: @LennCode", color = Color.White)
}


fun showAlertDontExistUser(usersHashMap: HashMap<String, String>, text: String, ctx: Context) {
    if (usersHashMap[text] == null) {
        Toast.makeText(ctx, "Usuario no existe ", Toast.LENGTH_SHORT).show()
    }else{

        Toast.makeText(ctx, "Completly bby ;) ", Toast.LENGTH_SHORT).show()

    }
}

