package me.varoa.nikkerv.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import coil.ImageLoader
import coil.request.ImageRequest
import me.varoa.nikkerv.R
import me.varoa.nikkerv.data.model.Nikke
import me.varoa.nikkerv.databinding.ItemGridNikkeBinding
import me.varoa.nikkerv.databinding.ItemListNikkeBinding
import me.varoa.nikkerv.ui.adapter.NikkeAdapter.Companion.LAYOUT_GRID
import me.varoa.nikkerv.ui.adapter.NikkeAdapter.Companion.LAYOUT_LIST
import me.varoa.nikkerv.ui.adapter.NikkeAdapter.NikkeViewHolder
import me.varoa.nikkerv.ui.viewbinding.viewBinding
import java.util.Locale

class NikkeAdapter(
  private val imageLoader: ImageLoader, private val onClick: (Nikke) -> Unit
) : ListAdapter<Nikke, NikkeViewHolder>(NIKKE_COMPARATOR) {
  companion object {
    val NIKKE_COMPARATOR = object : DiffUtil.ItemCallback<Nikke>() {
      override fun areContentsTheSame(
        oldItem: Nikke, newItem: Nikke
      ): Boolean = oldItem.id == newItem.id

      override fun areItemsTheSame(
        oldItem: Nikke, newItem: Nikke
      ): Boolean = oldItem.id == newItem.id
    }

    const val LAYOUT_LIST = 0
    const val LAYOUT_GRID = 1
  }

  private var viewType = true

  inner class NikkeViewHolder(private val binding: ViewBinding, private val itemType: Int) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(data: Nikke?) {
      if (data == null) return
      binding.root.setOnClickListener { onClick(data) }
      val imgBuilder = ImageRequest.Builder(binding.root.context).data(R.drawable.ic_arrow_left)
        .allowHardware(true)

      when (itemType) {
        LAYOUT_LIST -> {
          (binding as ItemListNikkeBinding).apply {
            val imgData = imgBuilder.target(this.ivIcon).build()
            imageLoader.enqueue(imgData)
            tvName.text = data.name
            tvDescription.text = "${data.burstType.string} ${data.rarity.name} NIKKE from ${
              data.manufacturer.name.toLowerCase().capitalize()
            }"
          }
        }
        else -> {
          (binding as ItemGridNikkeBinding).apply {
            val imgData = imgBuilder.target(this.ivIcon).build()
            imageLoader.enqueue(imgData)
            tvName.text = data.name
          }
        }
      }
    }
  }

  fun toggleViewType(): Boolean {
    viewType = !viewType
    return viewType
  }

  override fun getItemViewType(position: Int): Int {
    if (viewType) {
      return LAYOUT_LIST
    } else {
      return LAYOUT_GRID
    }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NikkeViewHolder {
    return if(viewType == LAYOUT_LIST) {
      NikkeViewHolder(parent.viewBinding(ItemListNikkeBinding::inflate), viewType)
    }else{
      NikkeViewHolder(parent.viewBinding(ItemGridNikkeBinding::inflate), viewType)
    }
  }

  override fun onBindViewHolder(holder: NikkeViewHolder, position: Int) {
    val data = getItem(position)
    holder.bind(data)
  }
}