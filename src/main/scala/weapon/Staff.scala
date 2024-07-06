package weapon

/** Represents a Staff, a type of weapon.
 *
 * A Staff is a magical weapon with a name, attack power, weight,
 * and additional magical attack power.
 *
 * @constructor Creates a new Staff with the specified properties.
 * @param name        The name of the Staff.
 * @param attack      The attack power of the Staff.
 * @param weight      The weight of the Staff.
 * @param magicAttack The magical attack power of the Staff.
 *                    
 * @author asouris
 */
class Staff(name: String, attack: Int, weight: Int, magicAttack: Int)
  extends AbstractMagicWeapon(name, attack, weight, magicAttack)  {

  /**
   * Checks if this Staff is equal to another object.
   *
   * Two Staffs are considered equal if they have the same name, attack power, and weight.
   *
   * @param other The object to compare with.
   * @return `true` if the objects are equal, `false` otherwise.
   */
  override def equals(other: Any): Boolean = {
    other match
      case staff1: Staff =>
        name == staff1.getName && attack == staff1.getAttack && weight == staff1.getWeight && magicAttack == staff1.getMagicAttack
      case _ =>
        false
  }

  /**
   * Returns a string representation of this Staff.
   *
   * @return A string representation containing the Staff's properties.
   */
  override def toString: String = {
    s"Staff($name, $attack, $weight, $magicAttack)"
  }

  /**
   * returns true if is equippable by a blackMage
   *
   * @return
   */
  override def isEquippableByBlackMage: Boolean = true

  /**
   * returns true if is equippable by a whiteMage
   *
   * @return
   */
  override def isEquippableByWhiteMage: Boolean = true


}