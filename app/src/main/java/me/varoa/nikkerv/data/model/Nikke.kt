package me.varoa.nikkerv.data.model

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
)
