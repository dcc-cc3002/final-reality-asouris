package weapon
import weapon.traits.EquippableByWarrior
import weapon.traits.EquippableByPaladin

/** Represents an Axe, a type of weapon.
 *
 * An Axe is a weapon with a name, attack power, weight, and an optional owner.
 *
 * @constructor Creates a new Axe with the specified properties.
 * @param name   The name of the Axe.
 * @param attack The attack power of the Axe.
 * @param weight The weight of the Axe.
 * @param owner  The optional owner of the Axe, typically a character who wields it.
 *
 * @author asouris
 */

class Axe(name: String, attack: Int, weight: Int)
  extends AbstractWeapon(name, attack, weight) with EquippableByWarrior with EquippableByPaladin{
  
  override def equals (other: Any): Boolean = {
    if(other.isInstanceOf[Axe]){
      val axe1 = other.asInstanceOf[Axe]
      name == axe1.name && attack == axe1.attack && weight == axe1.weight
    } else{
      false
    }
  }

  override def toString : String = {
    s"Axe($name, $attack, $weight)"
  }
}
