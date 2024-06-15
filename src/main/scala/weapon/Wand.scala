package weapon
import weapon.traits.EquippableByNinja
import weapon.traits.EquippableByBlackMage
import weapon.traits.EquippableByWhiteMage


/** Represents a Wand, a type of weapon.
 *
 * A Wand is a magical weapon with a name, attack power, weight,
 * and additional magical attack power.
 *
 * @constructor Creates a new Wand with the specified properties.
 * @param name        The name of the Wand.
 * @param attack      The attack power of the Wand.
 * @param weight      The weight of the Wand.
 * @param magicAttack The magical attack power of the Wand.
 *
 * @author asouris
 */
class Wand(name: String, attack: Int, weight: Int, magicAttack: Int)
  extends AbstractMagicWeapon(name, attack, weight, magicAttack) with EquippableByNinja with EquippableByBlackMage with EquippableByWhiteMage{

  /**
   * Checks if this Wand is equal to another object.
   *
   * Two Wands are considered equal if they have the same name, attack power, and weight.
   *
   * @param other The object to compare with.
   * @return `true` if the objects are equal, `false` otherwise.
   */
  override def equals(other: Any): Boolean = {
    other match
      case wand1: Wand =>
        name == wand1.getName && attack == wand1.getAttack && weight == wand1.getWeight && magicAttack == wand1.getMagicAttack
      case _ =>
        false
  }

  /**
   * Returns a string representation of this Wand.
   *
   * @return A string representation containing the Wand's properties.
   */
  override def toString: String = {
    s"Wand($name, $attack, $weight, $magicAttack)"
  }

}

