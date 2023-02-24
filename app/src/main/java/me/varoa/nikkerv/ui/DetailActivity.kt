package me.varoa.nikkerv.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.LiveFolders.INTENT
import android.text.Html
import androidx.core.text.HtmlCompat
import coil.imageLoader
import coil.request.ImageRequest
import logcat.logcat
import me.varoa.nikkerv.R
import me.varoa.nikkerv.data.dummy
import me.varoa.nikkerv.data.model.Nikke
import me.varoa.nikkerv.data.model.Rarity
import me.varoa.nikkerv.databinding.ActivityDetailBinding
import me.varoa.nikkerv.databinding.ActivityMainBinding
import me.varoa.nikkerv.ui.viewbinding.viewBinding

class DetailActivity : AppCompatActivity(R.layout.activity_detail) {
  companion object {
    const val EXTRA_NIKKE = "extra_nikke"
  }

  private val binding by viewBinding<ActivityDetailBinding>()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val nikkeData = if (Build.VERSION.SDK_INT >= 33) {
      intent.getParcelableExtra(EXTRA_NIKKE, Nikke::class.java)
    } else {
      @Suppress("DEPRECATION")
      intent.getParcelableExtra(EXTRA_NIKKE)
    } ?: dummy[0]

    binding.toolbar.apply {
      setNavigationOnClickListener { onBackPressedDispatcher.onBackPressed() }
      setOnMenuItemClickListener { menuItem ->
        when (menuItem.itemId) {
          R.id.action_share -> {
            logcat { "Share clicked!" }
            val shareText = getString(
              R.string.share_detail,
              nikkeData.name.lowercase(),
              nikkeData.name
            )
            Intent(Intent.ACTION_SEND).also {
              it.type = "text/html"
              it.putExtra(Intent.EXTRA_SUBJECT, "NikkeRv")
              it.putExtra(Intent.EXTRA_TEXT, shareText)
              startActivity(Intent.createChooser(it, "Share via"))
            }
            true
          }
          else -> false
        }
      }
    }
    bindData(nikkeData)
  }

  @SuppressLint("DiscouragedApi") // suppress getIdentifier, cause I'm trying to get the photo dynamically
  private fun bindData(data: Nikke) {
    binding.apply {
      val ctx = this.root.context
      tvName.text = data.name
      tvRarity.text = data.rarity.name
      tvRarity.setTextColor(
        resources.getColor(
          if (data.rarity == Rarity.SSR) R.color.nikke_ssr else R.color.nikke_sr,
          theme
        )
      )
      tvManufacturer.text = getString(
        R.string.text_detail_manufacturer,
        data.manufacturer.name.lowercase().replaceFirstChar(Char::uppercase)
      )
      tvSquad.text = getString(
        R.string.text_detail_squad,
        data.squadName
      )
      tvWeapon.text = getString(
        R.string.text_detail_weapon,
        data.weapon.name,
        data.weapon.fullname
      )
      tvClass.text = getString(
        R.string.text_detail_class,
        data.classType.name.lowercase().replaceFirstChar(Char::uppercase)
      )
      tvBurst.text = getString(
        R.string.text_detail_burst,
        data.burstType.string
      )
      tvDescription.text = data.description

      val imgData = ImageRequest.Builder(ctx).data(
        ctx.resources.getIdentifier("c${data.id}_fullbody", "drawable", ctx.packageName)
      ).allowHardware(true)
        .target(ivFullBody)
        .build()
      imageLoader.enqueue(imgData)
    }
  }
}