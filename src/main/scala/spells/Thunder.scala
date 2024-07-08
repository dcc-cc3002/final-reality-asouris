package spells

import character.players.AbstractMagicPlayer
import spells.traits.DarkSpell
import character.{Character, Enemy}
import controller.GameController
import character.Character

import scala.collection.mutable.ArrayBuffer
import scala.util.Random

/**
 * Represents a Thunder spell, which is a type of dark spell.
 *
 * The Thunder spell inflicts damage on the target character and has a chance to apply a paralysis effect.
 */
class Thunder extends DarkSpell {
  /** The mana cost of casting the Thunder spell. */
  private val cost : Int = 20

  /**
   * Gets the mana cost of the Thunder spell.
   *
   * @return The mana cost of the spell.
   */
  override def getCost: Int = cost

  /**
   * Activates the Thunder spell on the target character.
   *
   * This method calculates the damage based on the caster's attack power, reduces the target's life accordingly,
   * and deducts the mana cost from the caster. There is also a chance (30%) to apply a paralysis effect.
   *
   * @param target The character on whom the spell is to be cast.
   * @param mage   The magic player casting the spell.
   */
  override def activateSpell(target: Character, mage: AbstractMagicPlayer): Unit = {
    val damage = mage.getAttack

    target.setLife(-damage)

    val rand = new Random()
    val res = rand.nextInt(10)

    if (res == 0 || res == 1 || res == 2) {
      //add paralysis
    }

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
    mage.getMage.castThunder(target)
  }

  /** Overrides toString */
  override def toString: String = {
    "Thunder"
  }
}
