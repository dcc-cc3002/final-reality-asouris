package weapon

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
trait Weapon{
  
  /** The name of the weapon. */
  val name: String

  /** The damage per attack by the weapon. */
  val attack: Int

  /** The weight of the weapon*/
  val weight: Int

  /** The current owner of the weapon*/
  var owner: Character
}
