package com.example.onlineshopwb.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.onlineshop.ui.screens.components.PhoneField
import com.example.onlineshop.ui.screens.components.TopAppBarSample
import com.example.onlineshopwb.ui.valid.checkRussianLetters
import com.example.onlineshopwb.viewModels.ViewModelReg
import com.example.onlineshopwb.ui.theme.OnlineShopWBTheme


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun RegistrationScreen(viewModelDB: ViewModelReg = viewModel(factory = ViewModelReg.factory)) {

//    var name by remember {
//        mutableStateOf("")
//    }
    var isNameError by remember {
        mutableStateOf(false)
    }
    val isVisibleIconClearName by remember {
        derivedStateOf {
            viewModelDB.newName.value.isNotBlank()
        }
    }

//    var surname by remember {
//        mutableStateOf("")
//    }
    var isSurnameError by remember {
        mutableStateOf(false)
    }
    val isVisibleIconClearSurname by remember {
        derivedStateOf {
            viewModelDB.newSurname.value.isNotBlank()
        }
    }


    OnlineShopWBTheme {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            TopAppBarSample(title = "Вход")
        }

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            OutlinedTextField(
                value = viewModelDB.newName.value,
                onValueChange = {
                    viewModelDB.newName.value = it
                    isNameError = !checkRussianLetters(it)
                },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text
                ),
                label = { Text(text = "Имя", color = Color.Gray) },
                colors = if (!isNameError || viewModelDB.newName.value == "") {
                    OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.Gray,
                        unfocusedBorderColor = Color.Transparent,
                        cursorColor = Color.Gray
                    )
                } else {
                    OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = MaterialTheme.colorScheme.error,
                        unfocusedBorderColor = Color.Transparent,
                        cursorColor = MaterialTheme.colorScheme.error
                    )
                },
                shape = RoundedCornerShape(15.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                singleLine = true,
                trailingIcon = {
                    if (isVisibleIconClearName) {
                        IconButton(
                            onClick = { viewModelDB.newName.value = "" }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Clear,
                                contentDescription = "Clear"
                            )
                        }
                    }
                }
            )


            OutlinedTextField(
                value = viewModelDB.newSurname.value,
                onValueChange = {
                    viewModelDB.newSurname.value = it
                    isSurnameError = !checkRussianLetters(it)
                },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text
                ),
                label = { Text(text = "Фамилия", color = Color.Gray) },
                colors = if (!isSurnameError || viewModelDB.newSurname.value == "") {
                    OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.Gray,
                        unfocusedBorderColor = Color.Transparent,
                        cursorColor = Color.Gray
                    )
                } else {
                    OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = MaterialTheme.colorScheme.error,
                        unfocusedBorderColor = Color.Transparent,
                        cursorColor = MaterialTheme.colorScheme.error
                    )
                },
                shape = RoundedCornerShape(15.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                singleLine = true,
                trailingIcon = {
                    if (isVisibleIconClearSurname) {
                        IconButton(
                            onClick = {
                                viewModelDB.newSurname.value = ""
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Clear,
                                contentDescription = "Clear"
                            )
                        }
                    }


                }
            )

            PhoneField(viewModelDB.newPhoneNumber.value,
                mask = "+7 000 000-00-00",
                maskNumber = '0',
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                onPhoneChanged = { viewModelDB.newPhoneNumber.value = it })

            Button(
                onClick = { viewModelDB.insertUser() },///////////
                enabled = (!isNameError && viewModelDB.newName.value.isNotEmpty() && !isSurnameError && viewModelDB.newSurname.value.isNotEmpty()) && viewModelDB.newPhoneNumber.value.length == 10
            ) {
                Text("Войти")

            }


        }
    }
}


@Preview
@Composable
fun PreviewReg() {
    RegistrationScreen()
}

