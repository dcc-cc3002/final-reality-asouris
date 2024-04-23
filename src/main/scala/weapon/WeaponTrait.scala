package weapon
import character.players.Player
import character.players.traits.WeaponUser

/** Represents a weapon
  * @param name
  *   Name of the weapon
  * @param attack
  *   Damage per attack
  * @param weight
  *   Weight of the weapon
  * @param Owner
  *   Owner of the weapon
  *
  * @author
  *   asouris
  */
trait WeaponTrait{
  
  /** The name of the weapon. */
  val name: String

  /** The damage per attack by the weapon. */
  val attack: Int

  /** The weight of the weapon*/
  val weight: Int

  /** The current owner of the weapon*/
  var owner: Option[WeaponUser]
  
  /** Sets the owner of the weapon.
   *
   * @param character The player who will be set as the owner.
   * @return An Option of type AbstWeapon representing the owner of the weapon, if any.
   */
  def setOwner(character : Player) : Option[AbstWeapon] = None


}
