package me.varoa.nikkerv.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Nikke(
  val id: String,
  val name: String,
  val rarity: Rarity,
  val classType: ClassType,
  val weapon: WeaponType,
  val burstType: BurstType,
  val manufacturer: Manufacturer,
  val squadName: String,
  val description: String
) : Parcelable
