package spells

import character.players.{AbstractMagicPlayer, Player}
import spells.traits.LightSpell
import character.Character
import controller.GameController

import scala.collection.mutable.ArrayBuffer

/**
 * Represents a Healing spell, which is a type of light spell.
 *
 * The Healing spell restores a portion of the target character's life points.
 */
class Healing extends LightSpell{

  /** The mana cost of casting the Healing spell. */
  private val cost : Int = 15

  /**
   * Gets the mana cost of the Healing spell.
   *
   * @return The mana cost of the spell.
   */
  override def getCost: Int = cost

  /**
   * Activates the Healing spell on the target character.
   *
   * This method calculates the amount of life points to be restored based on a percentage of the target's maximum life,
   * adds this amount to the target's current life points, and deducts the mana cost from the caster.
   *
   * @param target The character on whom the spell is to be cast.
   * @param mage   The magic player casting the spell.
   */
  override def activateSpell(target: Character, mage: AbstractMagicPlayer): Unit = {
    val current = target.getLife
    val recover = (target.getMaxLife*0.3).toInt
    
    target.setLife(recover)
    
    mage.setMana(-getCost)
  }

  /**
   * Returns targets for a spell
   *
   * @param controller controller where the arrays of enemies and players are
   * @param character character casting spell
   * @return in this case players except from character
   */
  override def getTargets(controller: GameController, character: Character): ArrayBuffer[Character] = {
    var array = controller.getPlayers
    array -= character
    array
  }

  /**
   * gets mage instance and casts spell
   *
   * @param mage   caster
   * @param target target
   */
  def castByOn(mage: Character, target: Character): Unit = {
    mage.getMage.castHealing(target)
  }

  override def toString: String = {
    "Healing"
  }
}
