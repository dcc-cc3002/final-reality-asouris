package weapon
import weapon.traits.EquippableByBlackMage
import weapon.traits.EquippableByWhiteMage

/** Represents a Staff, a type of weapon.
 *
 * A Staff is a magical weapon with a name, attack power, weight, an optional owner,
 * and additional magical attack power.
 *
 * @constructor Creates a new Staff with the specified properties.
 * @param name        The name of the Staff.
 * @param attack      The attack power of the Staff.
 * @param weight      The weight of the Staff.
 * @param owner       The optional owner of the Staff, typically a character who wields it.
 * @param magicAttack The magical attack power of the Staff.
 *                    
 * @author asouris
 */
class Staff(name: String, attack: Int, weight: Int, magicAttack: Int)
  extends AbstractMagicWeapon(name, attack, weight, magicAttack) with EquippableByWhiteMage with EquippableByBlackMage {


  override def equals(other: Any): Boolean = {
    other match
      case staff1: Staff =>
        name == staff1.getName && attack == staff1.getAttack && weight == staff1.getWeight && magicAttack == staff1.getMagicAttack
      case _ =>
        false
  }

  override def toString: String = {
    s"Staff($name, $attack, $weight)"
  }
}