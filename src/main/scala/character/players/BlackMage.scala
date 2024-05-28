package character.players

import spells.traits.{DarkSpell, Spell}
import character.players.Player
import weapon.traits.EquippableByBlackMage
import weapon.Weapon
import exceptions.WeaponException
import character.Character

/** Represents a BlackMage.
  *
  * A BlackMage is a playable character.
  *
  * @param name
  *   The name of the character
  * @param maxLife     
  *   The max amount of life points 
  * @param life
  *   The life of the character
  * @param defense
  *   The defense of the character
  * @param weight
  *   The weight of the character
  * @param mana
  *   The mana of the character
 * @param maxMana
 *    The maximum amount of mana
  *
  * @constructor Creates a new Black Mage character with the specified properties.
  *
  * @author
  *   asouris
  */
class BlackMage(
                 name: String,
                 maxLife: Int,
                 life: Int,
                 defense: Int,
                 weight: Int,
                 mana: Int,
                 maxMana: Int
) extends AbstractMagicPlayer(name, maxLife, life, defense, weight, mana, maxMana) {

  /**
   * Checks whether this black mage is equal to another object.
   *
   * @param other The object to compare with.
   * @return True if the objects are equal, false otherwise.
   */
  override def equals(other: Any): Boolean = {
    other match
      case blackMage1: BlackMage =>
        name == blackMage1.getName && maxLife == blackMage1.getMaxLife && life == blackMage1.getLife && defense == blackMage1.getDefense && weight == blackMage1.getWeight && mana == blackMage1.getMana && maxMana == blackMage1.getMaxMana
      case _ =>
        false
  }

  /**
   * Returns a string representation of this black mage.
   *
   * @return A string representation containing the black mage's properties.
   */
  override def toString: String = {
    s"BlackMage($name, $maxLife, $life, $defense, $weight, $mana, $maxMana)"
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
