package character.players
import character.Character
import exceptions.WeaponException
import weapon.Weapon

import scala.collection.mutable.ArrayBuffer

/**
 * A trait representing a playable character.
 * Players can have weapons and can attempt to equip weapons.
 */
trait Player extends Character{

  /**
   * Retrieves the weapon currently equipped by the player.
   *
   * @return The currently equipped weapon.
   */
  def getWeapon : Weapon

  /**
   * Checks if the player has a weapon.
   *
   * @return True if the player has a weapon, false otherwise.
   */
  def hasWeapon : Boolean
  

  /**
   * Gets the attack of a character
   * @return Attack damage of a character
   */
  def getAttack: Int
  

}
