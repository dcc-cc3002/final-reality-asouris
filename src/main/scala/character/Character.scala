package character

import character.players.{AbstractMagicPlayer, Player}
import controller.GameController
import controller.states.GameState
import effects.Effect
import spells.traits.Spell
import weapon.Weapon

import scala.collection.mutable.ArrayBuffer

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

    /**
     * sets characters team in case of battle
     * @param team Array with characters
     */
    def setTeam(team : ArrayBuffer[Character]) : Unit

    /**
     * gets the array with all ally characters
     * @return an array with allies
     */
    def getTeam : ArrayBuffer[Character]

    /**
     * Attempts to equip a weapon to the player.
     * By default, this method throws a WeaponException indicating that the character cannot equip the weapon.
     * Subclasses of class Player override this method to implement equipping a valid weapon.
     *
     * @param weapon The weapon to be equipped.
     * @throws WeaponException If the character cannot equip the specified weapon(or a weapon at all.
     */
    def equip(weapon: Weapon): Unit

    /**
     * returns an array with available actions for the player
     *
     * @return array with options
     */
    def getActions: Array[GameState]

    /**
     * if character is a mage, returns an array with avaible spells
     * return empty array otherwise
     * @param character 
     * @return array with spells
     */
    def getSpells(character: Character) : Array[Spell]

    /**
     * gets returns the instance as a magic player for casting spells.
     * @return instance as magic player
     */
    def getMage : AbstractMagicPlayer

    /**
     * sets the value of attribute paralyzed
     * @param value
     */
    def setParalyzed(value:Boolean) : Unit
    
    /**
     * Adds a effect to the list of active effects
     * @param effect the effect to be added
     */
    def addEffect(effect : Effect): Unit

    /**
     * Chooses a target and attacks it
     * @param controller holds information about possible targets
     */
    def chooseAndAttackTarget(controller : GameController) : Unit

    
}
