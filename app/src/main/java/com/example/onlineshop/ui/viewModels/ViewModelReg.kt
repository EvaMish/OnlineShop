package com.example.onlineshop.ui.viewModels


import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.onlineshop.data.db.App
import com.example.onlineshop.data.db.AppDB
import com.example.onlineshop.data.db.User
import kotlinx.coroutines.launch

class ViewModelReg(private val database: AppDB) : ViewModel() {
    val newName = mutableStateOf("")
    val newSurname = mutableStateOf("")
    val newPhoneNumber = mutableStateOf("")

    fun insertUser() = viewModelScope.launch {
        val user =
            User(
                userName = newName.value,
                userSurname = newSurname.value,
                userPhoneNumber = newPhoneNumber.value
            )

        database.dao.insertUser(user)
    }


    companion object {
        val factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>, extras: CreationExtras
            ): T {
                val dataBase =
                    (checkNotNull(extras[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY]) as App).database
                return ViewModelReg(dataBase) as T
            }

        }

    }
}