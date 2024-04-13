package weapon

/** Represents a Staff, a type of weapon.
 *
 * A Staff is a magical weapon with a name, attack power, weight, an optional owner,
 * and additional magical attack power.
 *
 * @constructor Creates a new Staff with the specified properties.
 * @param name        The name of the Staff.
 * @param attack      The attack power of the Staff.
 * @param weight      The weight of the Staff.
 * @param owner       The optional owner of the Staff, typically a character who wields it.
 * @param magicAttack The magical attack power of the Staff.
 *                    
 * @author asouris
 */
class Staff(val name: String, val attack: Int, val weight: Int, var owner: Character, var magicAttack: Int) extends Weapon with MagicWeapon {

}