package weapon

/**
 * Represents an Axe, a type of weapon.
 *
 * An Axe is a weapon with a name, attack power, weight
 *
 * @constructor Creates a new Axe with the specified properties.
 * @param name   The name of the Axe.
 * @param attack The attack power of the Axe.
 * @param weight The weight of the Axe.
 *               
 * @author asouris
 */

class Axe(name: String, attack: Int, weight: Int)
  extends AbstractWeapon(name, attack, weight){
  /**
   * Checks if this Axe is equal to another object.
   *
   * Two Axes are considered equal if they have the same name, attack power, and weight.
   *
   * @param other The object to compare with.
   * @return `true` if the objects are equal, `false` otherwise.
   */
  override def equals (other: Any): Boolean = {
    other match
      case axe1: Axe =>
        name == axe1.getName && attack == axe1.getAttack && weight == axe1.getWeight
      case _ =>
        false
  }

  /**
   * Returns a string representation of this Axe.
   *
   * @return A string representation containing the Axe's properties.
   */
  override def toString : String = {
    s"Axe($name, $attack, $weight)"
  }

  /**
   * returns true if is equippable by a paladin
   *
   * @return
   */
  override def isEquippableByPaladin: Boolean = true

  /**
   * returns true if is equippable by a warrior
   *
   * @return
   */
  override def isEquippableByWarrior: Boolean = true
  

}
