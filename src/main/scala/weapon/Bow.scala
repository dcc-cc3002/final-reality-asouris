package weapon

import weapon.traits.EquippableByWarrior
import weapon.traits.EquippableByNinja
import weapon.traits.EquippableByWhiteMage


/** Represents a Bow, a type of weapon.
 *
 * A Bow is weapon with a name, attack power, weight, and an optional owner.
 *
 * @constructor Creates a new Bow with the specified properties.
 * @param name   The name of the Bow.
 * @param attack The attack power of the Bow.
 * @param weight The weight of the Bow.
 * @param owner  The optional owner of the Bow, typically a character who wields it.
 * 
 * @author asouris
 */
class Bow(name: String, attack: Int, weight: Int)
  extends AbstractWeapon(name, attack, weight) with EquippableByWarrior with EquippableByNinja with EquippableByWhiteMage{

  override def equals(other: Any): Boolean = {
    other match
      case bow1: Bow =>
        name == bow1.getName && attack == bow1.getAttack && weight == bow1.getWeight
      case _ =>
        false
  }

  override def toString: String = {
    s"Bow($name, $attack, $weight)"
  }
}

