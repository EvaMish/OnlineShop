package com.example.onlineshop.ui.screens.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.onlineshop.ui.screens.RegistrationScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarSample(title:String){
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        CenterAlignedTopAppBar(
            title = { Text(title, fontSize = 15.sp ) }
        )

    }
}

@Preview
@Composable
fun PreviewReg() {
    TopAppBarSample("Вход")
}