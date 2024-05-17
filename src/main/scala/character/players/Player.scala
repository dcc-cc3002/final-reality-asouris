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

}
