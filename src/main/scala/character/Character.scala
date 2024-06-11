package character

import character.players.Player

/** Represents a character in the game.
 *
 * A character can be a playable character controlled by the player, or an enemy controlled by the computer.
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
     * Retrieves the max amount of life of the character.
     *
     * @return The max amount of life of the character.
     */
    def getMaxLife: Int

    /**
     * Sets the life points of the character to the specified value.
     *
     */
    def setLife(value: Int): Unit

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
     * Receives an attack from another character.
     *
     * @param attack The amount of attack received.
     */
    def receiveAttack(attack : Int): Unit

    /**
     * Attacks an enemy.
     *
     * @param enemy The enemy to be attacked.
     */
    def attackEnemy(enemy: Enemy) : Unit

    /**
     * Attacks a player.
     *
     * @param player The player to be attacked.
     */
    def attackPlayer(player: Player) : Unit

    /**
     * Calculates the current ActionBar for the character
     * @return Action bar of the character
     */
    def getActionBar : Double

    /**
     * returns true weather the character has active effects or not
     * @return weather the character has active effects or not
     */
    def hasEffects : Boolean

    /**
     * applies the active effects the character may have
     */
    def applyEffects() : Unit

    /**
     * returns true if the character has active a paralyze effect
     * @return weather the character has active a paralyze effect
     */
    def isParalyzed : Boolean
}
