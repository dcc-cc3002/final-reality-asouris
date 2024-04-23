package weapon

import character.players.Player
import character.players.traits.SwordUser

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

class Sword(override val name: String, override val attack: Int, override val weight: Int)
  extends AbstWeapon(name, attack, weight){

  def setOwner(player: SwordUser): Option[AbstWeapon] = {
    super.setValidOwner(player)
    Some(this)
  }

  override def equals(other: Any): Boolean = {
    if (other.isInstanceOf[Sword]) {
      val sword1 = other.asInstanceOf[Sword]
      name == sword1.name && attack == sword1.attack && weight == sword1.weight
    } else {
      false
    }
  }

  override def toString: String = {
    s"Sword($name, $attack, $weight)"
  }
}
