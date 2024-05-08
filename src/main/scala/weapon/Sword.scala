package weapon
import weapon.traits.EquippableByPaladin
import weapon.traits.EquippableByWarrior
import weapon.traits.EquippableByNinja
import weapon.traits.EquippableByBlackMage

/** Represents a Sword, a type of weapon.
 *
 * A Sword is a weapon with a name, attack power, weight, and an optional owner.
 *
 * @constructor Creates a new Sword with the specified properties.
 * @param name   The name of the Sword.
 * @param attack The attack power of the Sword.
 * @param weight The weight of the Sword.
 * @param owner  The optional owner of the Sword, typically a character who wields it.
 *
 * @author asouris
 */

class Sword(name: String, attack: Int, weight: Int)
  extends AbstractWeapon(name, attack, weight) with EquippableByPaladin with EquippableByNinja with EquippableByWarrior with EquippableByBlackMage{
  

  override def equals(other: Any): Boolean = {
    other match
      case sword1: Sword =>
        name == sword1.getName && attack == sword1.getAttack && weight == sword1.getWeight
      case _ =>
        false
  }

  override def toString: String = {
    s"Sword($name, $attack, $weight)"
  }
}
