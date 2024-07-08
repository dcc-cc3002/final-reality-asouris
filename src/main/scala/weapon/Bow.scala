package weapon



/** Represents a Bow, a type of weapon.
 *
 * A Bow is weapon with a name, attack power, weight.
 *
 * @constructor Creates a new Bow with the specified properties.
 * @param name   The name of the Bow.
 * @param attack The attack power of the Bow.
 * @param weight The weight of the Bow.
 * 
 * @author asouris
 */
class Bow(name: String, attack: Int, weight: Int)
  extends AbstractWeapon(name, attack, weight) {
  /**
   * Checks if this Bow is equal to another object.
   *
   * Two Bows are considered equal if they have the same name, attack power, and weight.
   *
   * @param other The object to compare with.
   * @return `true` if the objects are equal, `false` otherwise.
   */
  override def equals(other: Any): Boolean = {
    other match
      case bow1: Bow =>
        name == bow1.getName && attack == bow1.getAttack && weight == bow1.getWeight
      case _ =>
        false
  }

  /**
   * Returns a string representation of this Bow.
   *
   * @return A string representation containing the Bow's properties.
   */
  override def toString: String = {
    s"Bow($name, $attack, $weight)"
  }

  /**
   * returns true if is equippable by a warrior
   *
   * @return
   */
  override def isEquippableByWarrior: Boolean = true

  /**
   * returns true if is equippable by a ninja
   *
   * @return
   */
  override def isEquippableByNinja: Boolean = true

  /**
   * returns true if is equippable by a whitemage
   *
   * @return
   */
  override def isEquippableByWhiteMage: Boolean = true

}

