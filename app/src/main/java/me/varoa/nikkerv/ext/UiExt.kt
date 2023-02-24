package me.varoa.nikkerv.ext

import androidx.appcompat.app.AppCompatDelegate

fun toggleAppTheme(value: Int) {
  AppCompatDelegate.setDefaultNightMode(
    when (value) {
      1 -> AppCompatDelegate.MODE_NIGHT_NO
      2 -> AppCompatDelegate.MODE_NIGHT_YES
      else -> AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
    }
  )
}