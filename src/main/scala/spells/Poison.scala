package spells

import character.Enemy
import character.players.{AbstractMagicPlayer, Player}
import spells.traits.LightSpell
import character.Character

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
    //Poison add later
    mage.setMana(-getCost)
  }


}
