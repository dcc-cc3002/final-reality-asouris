package weapon
import character.players.Player
import character.players.traits.WandUser

/** Represents a Wand, a type of weapon.
 *
 * A Wand is a magical weapon with a name, attack power, weight, an optional owner,
 * and additional magical attack power.
 *
 * @constructor Creates a new Wand with the specified properties.
 * @param name        The name of the Wand.
 * @param attack      The attack power of the Wand.
 * @param weight      The weight of the Wand.
 * @param owner       The optional owner of the Wand, typically a character who wields it.
 * @param magicAttack The magical attack power of the Wand.
 *
 * @author asouris
 */
class Wand(override val name: String, override val attack: Int, override val weight: Int, var magicAttack: Int)
  extends AbstWeapon(name, attack, weight) with MagicWeapon  {
  
  def setOwner(player: WandUser): Option[AbstWeapon] = {
    super.setValidOwner(player)
    Some(this)
  }

  override def equals(other: Any): Boolean = {
    if (other.isInstanceOf[Wand]) {
      val wand1 = other.asInstanceOf[Wand]
      name == wand1.name && attack == wand1.attack && weight == wand1.weight
    } else {
      false
    }
  }

  override def toString: String = {
    s"Wand($name, $attack, $weight)"
  }

}

