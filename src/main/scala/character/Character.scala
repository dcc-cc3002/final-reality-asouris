package character

/** Represents a character in the game.
 *
 * A character can be a playable character controlled by the player, or an enemy controlled by the computer.
 *
 * @param name The name of the character.
 * @param life The current life of the character.
 * @param defense The defense of the character.
 * @param weight The weight of the character.
 *
 * @constructor Creates a new character with the specified properties.
 *
 * @author asouris
 */
trait Character(){
    /** Character's name*/
    val name: String
    /** Character's life*/
    var life: Int
    /** Character's defense*/
    var defense: Int 
    /** Character's weight*/
    var weight: Int

    /** Checks if the character is defeated.
     *
     * Returns `true` if the character's life points have reached zero or less, indicating defeat.
     * Returns `false` otherwise.
     *
     * @return `true` if the character is defeated, `false` otherwise.
     */
    def isDefeated: Boolean
    def attackCharacter(character : Character) : Unit
    def receiveAttack(attack : Int): Unit

}
