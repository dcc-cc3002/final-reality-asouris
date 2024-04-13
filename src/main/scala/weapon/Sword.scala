package weapon

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

class Sword(val name: String, val attack: Int, val weight: Int, var owner: Character) extends Weapon{

}
