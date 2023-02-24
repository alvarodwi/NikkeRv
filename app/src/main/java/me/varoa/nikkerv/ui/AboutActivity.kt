package me.varoa.nikkerv.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.imageLoader
import coil.request.ImageRequest
import coil.transform.RoundedCornersTransformation
import me.varoa.nikkerv.R
import me.varoa.nikkerv.databinding.ActivityAboutBinding
import me.varoa.nikkerv.databinding.ActivityDetailBinding
import me.varoa.nikkerv.ui.viewbinding.viewBinding

class AboutActivity : AppCompatActivity(R.layout.activity_about) {
  private val binding by viewBinding<ActivityAboutBinding>()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding.toolbar.setNavigationOnClickListener { onBackPressedDispatcher.onBackPressed() }
    val imgData = ImageRequest.Builder(this).data(R.drawable.profile).allowHardware(true)
      .transformations(RoundedCornersTransformation(16f))
      .target(binding.ivProfile).build()
    imageLoader.enqueue(imgData)
  }
}