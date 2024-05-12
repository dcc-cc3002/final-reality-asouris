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
  * @param magicPoints
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

  /**
   * Checks whether this black mage is equal to another object.
   *
   * @param other The object to compare with.
   * @return True if the objects are equal, false otherwise.
   */
  override def equals(other: Any): Boolean = {
    other match
      case blackMage1: BlackMage =>
        name == blackMage1.getName && life == blackMage1.getLife && defense == blackMage1.getDefense && weight == blackMage1.getWeight && magicPoints == blackMage1.getMagicPoints
      case _ =>
        false
  }

  /**
   * Returns a string representation of this black mage.
   *
   * @return A string representation containing the black mage's properties.
   */
  override def toString: String = {
    s"BlackMage($name, $life, $defense, $weight, $magicPoints)"
  }

  /**
   * Equips a new weapon to the black mage via the method validEquip.
   * This method overrides the one declared in Player.
   *
   * @param newWeapon The weapon to be equipped.
   */
  def equip(newWeapon: EquippableByBlackMage): Unit = {
    super.validEquip(newWeapon.toWeapon)
  }

}
