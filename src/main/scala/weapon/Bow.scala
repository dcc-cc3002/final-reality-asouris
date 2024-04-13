package weapon

/** Represents a Bow, a type of weapon.
 *
 * A Bow is weapon with a name, attack power, weight, and an optional owner.
 *
 * @constructor Creates a new Bow with the specified properties.
 * @param name   The name of the Bow.
 * @param attack The attack power of the Bow.
 * @param weight The weight of the Bow.
 * @param owner  The optional owner of the Bow, typically a character who wields it.
 * 
 * @author asouris
 */
class Bow(val name: String, val attack: Int, val weight: Int, var owner: Character) extends Weapon{

}

