package character.players

import weapon.traits.EquippableByPaladin

/** Represents a Paladin.
  *
  * A Paladin is a playable character
  *
  * @param name
  *   The name of the character
  * @param life
  *   The life of the character
  * @param defense
  *   The defense of the character
  * @param weight
  *   The weight of the character
  * @param weapon
  *   The weapon of the character
  *
  * @constructor Creates a new Paladin character with the specified properties.
  *
  * @author
  *   asouris
  */
class Paladin(name: String,
    life: Int,
    defense: Int,
    weight: Int
) extends AbstractPlayer(name, life, defense, weight) {
  
  
  

  override def equals(other: Any): Boolean = {
    other match
      case paladin1: Paladin =>
        name == paladin1.getName && life == paladin1.getLife && defense == paladin1.getDefense && weight == paladin1.getWeight
      case _ =>
        false
  }

  override def toString: String = {
    s"Paladin($name, $life, $defense, $weight)"
  }

  def equip(newWeapon: EquippableByPaladin): Unit = {
    super.validEquip(newWeapon.toWeapon)
  }
}
