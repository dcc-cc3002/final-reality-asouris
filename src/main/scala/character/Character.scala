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

    /**
     * Retrieves the name of the character.
     *
     * @return The name of the character.
     */
    def getName: String

    /**
     * Retrieves the current life points of the character.
     *
     * @return The current life points of the character.
     */
    def getLife: Int

    /**
     * Retrieves the defense value of the character.
     *
     * @return The defense value of the character.
     */
    def getDefense: Int

    /**
     * Retrieves the weight of the character.
     *
     * @return The weight of the character.
     */
    def getWeight: Int

    /**
     * Checks if the character is defeated.
     *
     * Returns `true` if the character's life points have reached zero or less, indicating defeat.
     * Returns `false` otherwise.
     *
     * @return `true` if the character is defeated, `false` otherwise.
     */
    def isDefeated: Boolean

    /**
     * Attacks another character.
     *
     * @param character The character to be attacked.
     */
    def attackCharacter(character : Character) : Unit

    /**
     * Receives an attack from another character.
     *
     * @param attack The amount of attack received.
     */
    def receiveAttack(attack : Int): Unit

}
