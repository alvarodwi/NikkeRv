package me.varoa.nikkerv.ui

import android.content.Intent
import android.content.res.Configuration.UI_MODE_NIGHT_MASK
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_YES
import androidx.appcompat.app.AppCompatDelegate.getDefaultNightMode
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import coil.imageLoader
import logcat.logcat
import me.varoa.nikkerv.R
import me.varoa.nikkerv.R.layout
import me.varoa.nikkerv.data.dummy
import me.varoa.nikkerv.databinding.ActivityMainBinding
import me.varoa.nikkerv.ext.toggleAppTheme
import me.varoa.nikkerv.ui.adapter.NikkeAdapter
import me.varoa.nikkerv.ui.viewbinding.viewBinding

class MainActivity : AppCompatActivity(layout.activity_main) {
    private val binding by viewBinding<ActivityMainBinding>()
    private val isDarkMode
        get() = if (getDefaultNightMode() == MODE_NIGHT_FOLLOW_SYSTEM) {
            resources.configuration.uiMode and UI_MODE_NIGHT_MASK == UI_MODE_NIGHT_YES
        } else getDefaultNightMode() == MODE_NIGHT_YES

    private lateinit var rvAdapter: NikkeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.appBarMain.apply {
            menu.getItem(1).icon = ContextCompat.getDrawable(
                context,
                if (isDarkMode) R.drawable.ic_moon else R.drawable.ic_sun
            )
            this.setOnMenuItemClickListener { menuItem ->
                when (menuItem.itemId) {
                    R.id.action_layout -> {
                        val isListView = rvAdapter.toggleViewType()
                        if (isListView) {
                            binding.rvMain.layoutManager = LinearLayoutManager(context)
                            menuItem.icon = ContextCompat.getDrawable(context, R.drawable.ic_grid)
                        } else {
                            binding.rvMain.layoutManager = GridLayoutManager(context, 2)
                            menuItem.icon = ContextCompat.getDrawable(context, R.drawable.ic_list)
                        }
                        true
                    }
                    R.id.action_theme -> {
                        logcat { "Dark mode is $isDarkMode" }
                        if (isDarkMode) toggleAppTheme(1) else toggleAppTheme(2)
                        logcat { "Dark mode after is $isDarkMode" }
                        delegate.applyDayNight()
                        false
                    }
                    R.id.action_about_page -> {
                        Intent(this@MainActivity, AboutActivity::class.java).also {
                            startActivity(it)
                        }
                        true
                    }
                    else -> false
                }
            }
        }
        binding.rvMain.apply {
            rvAdapter = NikkeAdapter(context.imageLoader, onClick = { nikke ->
                Intent(this@MainActivity, DetailActivity::class.java).also {
                    it.putExtra(DetailActivity.EXTRA_NIKKE, nikke)
                    startActivity(it)
                }
            })
            this.adapter = rvAdapter
            this.layoutManager = LinearLayoutManager(context)

            rvAdapter.submitList(dummy)
        }
    }
}
