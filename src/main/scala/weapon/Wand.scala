package weapon

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
class Wand(val name: String, val attack: Int, val weight: Int, var owner: Character, var magicAttack: Int) extends Weapon with MagicWeapon {

}

