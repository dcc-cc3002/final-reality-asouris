package spells.traits

import character.players.{AbstractMagicPlayer, Player}
import character.{Character, Enemy}
import controller.GameController
import exceptions.SpellException

import scala.collection.mutable.ArrayBuffer

/**
 * Represents a spell that can be cast by a magic player.
 *
 * This trait defines the basic structure and behavior for a spell,
 * including its cost and the action of activating the spell on a target.
 */
trait Spell {

  /**
   * Gets the mana cost of the spell.
   *
   * @return The mana cost of the spell.
   */
  def getCost: Int

  /**
   * Activates the spell on the target character.
   *
   * @param target The character on whom the spell is to be cast.
   * @param mage   The magic player casting the spell.
   */
  def activateSpell(target: Character, mage: AbstractMagicPlayer): Unit

  /**
   * Returns targets for a spell
   *
   * @param controller controller where the arrays of enemies and players are
   * @param character  character casting spell
   * @return array with targets
   */
  def getTargets(controller : GameController, character: Character) : ArrayBuffer[Character]

  /**
   * sends casting on to mages function
   * @param mage caster
   * @param target target
   */
  def castByOn(mage: Character, target: Character) : Unit

}
