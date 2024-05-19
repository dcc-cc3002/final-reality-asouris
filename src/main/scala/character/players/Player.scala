package character.players
import character.Character
import exceptions.WeaponException
import weapon.Weapon

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
   * Attempts to equip a weapon to the player.
   * By default, this method throws a WeaponException indicating that the player cannot equip the weapon.
   * Subclasses of Player override this method to implement equipping a valid weapon.
   *
   * @param weapon The weapon to be equipped.
   * @throws WeaponException If the player cannot equip the specified weapon.
   */
  def equip(weapon: Weapon): Unit = {
    throw WeaponException(s"$this cannot equip $weapon")
  }

  /**
   * Unequipps a weapon by removing the player from being the owner of the weapon, then removing the weapon
   * from the equippedWeapon attribute.
   */
  def unequipWeapon() : Unit

}
