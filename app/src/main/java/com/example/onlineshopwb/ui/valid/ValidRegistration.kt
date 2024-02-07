package com.example.onlineshopwb.ui.valid

fun checkRussianLetters(input: String): Boolean {
    for (char in input) {
        // Проверяем, является ли символ русской буквой (в нижнем или верхнем регистре)
        if (char in 'а'..'я' || char in 'А'..'Я') {
            continue
        } else {
            return false
        }
    }
    return true
}




