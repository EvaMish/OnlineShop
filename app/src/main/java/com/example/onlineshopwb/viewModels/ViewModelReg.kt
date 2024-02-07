package com.example.onlineshopwb.viewModels


import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.onlineshopwb.db.AppDB
import com.example.onlineshopwb.db.Users
import com.example.onlineshopwb.App
import kotlinx.coroutines.launch

class ViewModelReg(private val database: AppDB) : ViewModel() {
    val newName = mutableStateOf("")
    val newSurname = mutableStateOf("")
    val newPhoneNumber = mutableStateOf("")

    fun insertUser() = viewModelScope.launch {
        val user =
            Users(
                userName = newName.value,
                userSurname = newSurname.value,
                userPhoneNumber = newPhoneNumber.value
            )

        database.dao.insertUser(user)
        newName.value = "done"
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