package me.varoa.nikkerv.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import coil.imageLoader
import logcat.logcat
import me.varoa.nikkerv.R
import me.varoa.nikkerv.R.layout
import me.varoa.nikkerv.data.dummy
import me.varoa.nikkerv.databinding.ActivityMainBinding
import me.varoa.nikkerv.ui.adapter.NikkeAdapter
import me.varoa.nikkerv.ui.viewbinding.viewBinding

class MainActivity : AppCompatActivity(layout.activity_main) {
  private val binding by viewBinding<ActivityMainBinding>()

  private lateinit var rvAdapter: NikkeAdapter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    binding.appBarMain.apply {
      this.setOnMenuItemClickListener { menuItem ->
        when (menuItem.itemId) {
          R.id.action_layout -> {
            val flag = rvAdapter.toggleViewType()
            if (flag) {
              binding.rvMain.layoutManager = LinearLayoutManager(context)
            } else {
              binding.rvMain.layoutManager = GridLayoutManager(context, 2)
            }
            logcat { "Layout clicked! & $flag" }
            true
          }
          R.id.action_theme -> {
            logcat { "Theme clicked!" }
            true
          }
          R.id.action_about -> {
            logcat { "About clicked!" }
            true
          }
          else -> false
        }
      }
    }
    binding.rvMain.apply {
      rvAdapter = NikkeAdapter(context.imageLoader, onClick = { nikke ->
        logcat { "${nikke.name} clicked!" }
      })
      this.adapter = rvAdapter
      this.layoutManager = LinearLayoutManager(context)

      rvAdapter.submitList(dummy)
    }
  }
}