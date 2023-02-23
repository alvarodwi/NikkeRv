package me.varoa.nikkerv.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import me.varoa.nikkerv.R.layout

class DetailActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(layout.activity_detail)
  }
}