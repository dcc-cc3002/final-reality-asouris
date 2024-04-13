package weapon

/** Represents a MagicWeapon, a type of weapon with magical properties.
 *
 * A MagicWeapon is a weapon that has an additional magical attack.
 *
 * @tparam A type that extends Weapon. Represents the type of weapon that also has magical properties.
 * @constructor Creates a new MagicWeapon trait with the specified properties.
 *
 * @author asouris
 */
trait MagicWeapon extends Weapon {
  
  /** The magical attack power of the MagicWeapon. */
  var magicAttack: Int
}
