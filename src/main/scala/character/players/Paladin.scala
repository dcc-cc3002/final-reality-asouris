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
class Paladin(
    name: String,
    life: Int,
    defense: Int,
    weight: Int
) extends AbstractPlayer(name, life, defense, weight) {

  override def equals(other: Any): Boolean = {
    if (other.isInstanceOf[Paladin]) {
      val paladin1 = other.asInstanceOf[Paladin]
      name == paladin1.name && life == paladin1.life && defense == paladin1.defense && weight == paladin1.weight
    } else {
      false
    }
  }

  override def toString: String = {
    s"Paladin($name, $life, $defense, $weight)"
  }

  def equip(newWeapon: EquippableByPaladin): Unit = {
    //si llegó hasta aqui es valido el equipar
    super.validEquip(Some(newWeapon.toWeapon))
  }
}
