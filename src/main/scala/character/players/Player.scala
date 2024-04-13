package character.players
import character.Character
import weapon.Weapon


/** Represents a Player
 * 
 * A character that can be controlled by the user
 *
 * @param name The name of the player character.
 * @param life The current life of the player character.
 * @param defense The defense stat of the player character.
 * @param weight The weight of the player character.
 *
 * @constructor Creates a new player character with the specified properties.
 *
 * @author asouris
 */
abstract class Player(val name: String, var life: Int, var defense: Int, var weight: Int) extends Character {

    /** Equips a weapon to the player character.
     *
     * @param weapon The weapon to be equipped.
     */
    def equipWeapon(weapon: Weapon): Unit

    /** Checks if the player character is defeated.
     *
     * Returns `true` if the player character's life points have reached zero or less, indicating defeat.
     * Returns `false` otherwise.
     *
     * @return `true` if the player character is defeated, `false` otherwise.
     */
    override def isDefeated: Boolean = life <= 0

}