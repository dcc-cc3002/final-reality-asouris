package spells

import character.players.AbstractMagicPlayer
import spells.traits.LightSpell
import character.{Character, Enemy}
import controller.GameController
import effects.ParalyzeEffect

import scala.collection.mutable.ArrayBuffer

/**
 * Represents a Paralysis spell, which is a type of light spell.
 *
 * The Paralysis spell is intended to immobilize the target character.
 * Currently, it only deducts the mana cost from the caster. The paralysis effect will be implemented later.
 */
class Paralysis extends LightSpell{
  /** The mana cost of casting the Paralysis spell. */
  private val cost : Int = 25

  /**
   * Gets the mana cost of the Paralysis spell.
   *
   * @return The mana cost of the spell.
   */
  override def getCost: Int = cost

  /**
   * Activates the Paralysis spell on the target character.
   *
   * This method currently deducts the mana cost from the caster.
   * The actual paralysis effect will be implemented later.
   *
   * @param target The character on whom the spell is to be cast.
   * @param mage   The magic player casting the spell.
   */
  override def activateSpell(target: Character, mage: AbstractMagicPlayer): Unit = {
    target.addEffect(new ParalyzeEffect(-1))
    mage.setMana(-getCost)
  }

  /**
   * Returns targets for a spell
   *
   * @param controller controller where the arrays of enemies and players are
   * @param character  character casting spell
   * @return in this case enemies
   */
  override def getTargets(controller: GameController, character: Character): ArrayBuffer[Character] = {
    controller.getEnemies
  }

  /**
   * gets mage instance and casts spell
   *
   * @param mage   caster
   * @param target target
   */
  def castByOn(mage: Character, target: Character): Unit = {
    mage.getMage.castParalysis(target)
  }
}
