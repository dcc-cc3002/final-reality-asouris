package spells

import character.Enemy
import character.players.{AbstractMagicPlayer, Player}
import spells.traits.LightSpell
import character.Character
import controller.GameController
import effects.PoisonEffect

import scala.collection.mutable.ArrayBuffer

/**
 * Represents a Poison spell, which is a type of light spell.
 *
 * The Poison spell is intended to inflict a poison effect on the target character.
 * Currently, it only deducts the mana cost from the caster. The poison effect will be implemented later.
 */
class Poison extends LightSpell{
  /** The mana cost of casting the Poison spell. */
  private val cost : Int = 30

  /**
   * Gets the mana cost of the Poison spell.
   *
   * @return The mana cost of the spell.
   */
  override def getCost: Int = cost

  /**
   * Activates the Poison spell on the target character.
   *
   * This method currently deducts the mana cost from the caster.
   * The actual poison effect will be implemented later.
   *
   * @param target The character on whom the spell is to be cast.
   * @param mage   The magic player casting the spell.
   */
  override def activateSpell(target: Character, mage: AbstractMagicPlayer): Unit = {
    target.addEffect(new PoisonEffect(mage.getAttack))
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
    mage.getMage.castPoison(target)
  }

  override def toString: String = {
    "Poison"
  }
}
