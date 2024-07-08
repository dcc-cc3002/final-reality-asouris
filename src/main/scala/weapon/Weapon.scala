package weapon
import character.players.Player

/**
 * Represents a weapon.
 *
 * This trait defines properties and behaviors common to all types of weapons.
 *
 * @author asouris
 */
trait Weapon {
  /**
   * Retrieves the name of the weapon.
   *
   * @return The name of the weapon.
   */
  def getName : String

  /**
   * Retrieves the attack power of the weapon.
   *
   * @return The attack power of the weapon.
   */
  def getAttack : Int

  /**
   * Retrieves the weight of the weapon.
   *
   * @return The weight of the weapon.
   */
  def getWeight : Int

  /**
   * Checks if the weapon has an owner.
   *
   * @return True if the weapon has an owner, false otherwise.
   */
  def hasOwner : Boolean

  /**
   * Retrieves the owner of the weapon, if any.
   *
   * @return An option containing the owner of the weapon, or None if the weapon has no owner.
   */
  def getOwner : Player

  /**
   * Sets the owner of the weapon.
   *
   * @param player The player to set as the owner of the weapon.
   */
  def setOwner(player: Player) : Unit

  /**
   * Converts this weapon to a generic weapon.
   *
   * This method returns a reference to itself, allowing it to be treated as a Weapon trait.
   *
   * @return The weapon itself.
   */
  def toWeapon : Weapon = this

  /**
   * Sets owner to none
   */
  def removeOwner() : Unit

  /**
   * returns true if is equippable by a ninja
   * @return
   */
  def isEquippableByNinja : Boolean

  /**
   * returns true if is equippable by a paladin
   *
   * @return
   */
  def isEquippableByPaladin: Boolean

  /**
   * returns true if is equippable by a warrior
   *
   * @return
   */
  def isEquippableByWarrior: Boolean

  /**
   * returns true if is equippable by a whiteMage
   *
   * @return
   */
  def isEquippableByWhiteMage: Boolean

  /**
   * returns true if is equippable by a blackMage
   *
   * @return
   */
  def isEquippableByBlackMage: Boolean
  
  
}
