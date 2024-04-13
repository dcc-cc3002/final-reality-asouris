package weapon

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

class Axe(val name: String, val attack: Int, val weight: Int, var owner: Character) extends Weapon{

}
