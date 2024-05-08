package character.players

import character.players.Player
import weapon.traits.EquippableByBlackMage
import weapon.Weapon
import exceptions.WeaponException

/** Represents a BlackMage.
  *
  * A BlackMage is a playable character.
  *
  * @param name
  *   The name of the character
  * @param life
  *   The life of the character
  * @param defense
  *   The defense of the character
  * @param weight
  *   The weight of the character
  * @param mana
  *   The magic points of the character
  *
  * @constructor Creates a new Black Mage character with the specified properties.
  *
  * @author
  *   asouris
  */
class BlackMage(
    name: String,
    life: Int,
    defense: Int,
    weight: Int,
    magicPoints: Int
) extends AbstractMagicPlayer(name, life, defense, weight, magicPoints) {

  override def equals(other: Any): Boolean = {
    if (other.isInstanceOf[BlackMage]) {
      val blackMage1 = other.asInstanceOf[BlackMage]
      name == blackMage1.getName && life == blackMage1.getLife && defense == blackMage1.getDefense && weight == blackMage1.getWeight && magicPoints == blackMage1.getMagicPoints
    } else {
      false
    }
  }

  override def toString: String = {
    s"BlackMage($name, $life, $defense, $weight, $magicPoints)"
  }

  def equip(newWeapon: EquippableByBlackMage): Unit = {
    //si llegó hasta aqui es valido el equipar
    super.validEquip(Some(newWeapon.toWeapon))
  }

}
