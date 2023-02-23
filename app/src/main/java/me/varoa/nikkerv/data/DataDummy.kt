package me.varoa.nikkerv.data

import me.varoa.nikkerv.data.model.BurstType
import me.varoa.nikkerv.data.model.ClassType
import me.varoa.nikkerv.data.model.Manufacturer
import me.varoa.nikkerv.data.model.Nikke
import me.varoa.nikkerv.data.model.Rarity
import me.varoa.nikkerv.data.model.WeaponType

val dummy = listOf(
  Nikke(
    id = "010",
    name = "Rapi",
    rarity = Rarity.SR,
    classType = ClassType.ATTACKER,
    weapon = WeaponType.AR,
    burstType = BurstType.BURST_III,
    manufacturer = Manufacturer.ELYSION,
    squadName = "Counters",
    description = "A troubled yet reliable girl who seeks to answer the question of just what Nikkes really are. " +
      "As a member of Counters, she always ensures harmonious relations between various squadmates."
  ),
  Nikke(
    id = "120",
    name = "N102",
    rarity = Rarity.SR,
    classType = ClassType.SUPPORTER,
    weapon = WeaponType.RL,
    burstType = BurstType.BURST_I,
    manufacturer = Manufacturer.MISSILIS,
    squadName = "Recall & Release",
    description = "A Nikke from Recall & Release who is outgoing and energetic. Yet, she inexplicably feels a sense of emptiness inside herself."
  ),
  Nikke(
    id = "202",
    name = "Dolla",
    rarity = Rarity.SSR,
    classType = ClassType.SUPPORTER,
    weapon = WeaponType.SR,
    burstType = BurstType.BURST_II,
    manufacturer = Manufacturer.TETRA,
    squadName = "Talentum",
    description = "A true enterprising spirit. Rumor has it that she's a VIP of a large illegal website. She is the most rational member of Talentum."
  ),
  Nikke(
    id = "222",
    name = "Scarlet",
    rarity = Rarity.SSR,
    classType = ClassType.ATTACKER,
    weapon = WeaponType.AR,
    burstType = BurstType.BURST_III,
    manufacturer = Manufacturer.PILGRIM,
    squadName = "Pioneer",
    description = "A wandering swordswoman from Pioneer who's partial to a good drink. " +
      "Despite the common perception of melee weapons being ineffective in combat, she chooses to wield a sword."
  ),
  Nikke(
    id = "082",
    name = "Liter",
    rarity = Rarity.SSR,
    classType = ClassType.SUPPORTER,
    weapon = WeaponType.SMG,
    burstType = BurstType.BURST_I,
    manufacturer = Manufacturer.MISSILIS,
    squadName = "Mighty Tools",
    description = "The leader of Mighty Tools. Contrary to her appearance, she has already lived a long life. " +
      "At present, no other NIKKE can surpass her when it comes to construction."
  ),
  Nikke(
    id = "080",
    name = "Centi",
    rarity = Rarity.SSR,
    classType = ClassType.DEFENDER,
    weapon = WeaponType.RL,
    burstType = BurstType.BURST_II,
    manufacturer = Manufacturer.MISSILIS,
    squadName = "Mighty Tools",
    description = "An artisan with incredible strength who puts her heart into everything she does, never failing to get the job done at Mighty Tools. " +
      "As Liter's first apprentice, she has great respect for her mentor. She always listens to what Liter says, and studies her techniques in earnest."
  ),
  Nikke(
    id = "140",
    name = "Sugar",
    rarity = Rarity.SSR,
    classType = ClassType.ATTACKER,
    weapon = WeaponType.SG,
    burstType = BurstType.BURST_III,
    manufacturer = Manufacturer.TETRA,
    squadName = "Cafe Sweety",
    description = "A gearhead, who gets a thrill from burning rubber, sells sugar coffee in Cafe Sweety."
  ),
  Nikke(
    id = "201",
    name = "Yan",
    rarity = Rarity.SSR,
    classType = ClassType.SUPPORTER,
    weapon = WeaponType.RL,
    burstType = BurstType.BURST_I,
    manufacturer = Manufacturer.TETRA,
    squadName = "Talentum",
    description = "An experienced merchant with a knack for striking deals. " +
      "She uses her business acumen to operate several large-scale supermarket chains. Talentum's rise to fame can all be traced back to her."
  ),
  Nikke(
    id = "220",
    name = "Snow White",
    rarity = Rarity.SSR,
    classType = ClassType.ATTACKER,
    weapon = WeaponType.AR,
    burstType = BurstType.BURST_III,
    manufacturer = Manufacturer.PILGRIM,
    squadName = "Inherit",
    description = "A puritanical pilgrim who wanders the surface in an effort to protect humanity. " +
      "As a member of Pioneer, her days are spent wiping out Raptures with extreme prejudice."
  ),
  Nikke(
    id = "091",
    name = "Vesti",
    rarity = Rarity.SSR,
    classType = ClassType.ATTACKER,
    weapon = WeaponType.RL,
    burstType = BurstType.BURST_III,
    manufacturer = Manufacturer.ELYSION,
    squadName = "Absolute",
    description = "A timid girl who is a crybaby. Despite this, she is actually said to be Absolute's strongest ace member."
  ),
)