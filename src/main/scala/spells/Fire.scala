package spells

import character.players.AbstractMagicPlayer
import spells.traits.DarkSpell
import character.Character

import scala.util.Random

/**
 * Represents a Fire spell, which is a type of dark spell.
 *
 * The Fire spell inflicts damage on the target character and has a chance to apply a burn effect.
 */

class Fire extends DarkSpell{

  /** The mana cost of casting the Fire spell. */
  private val cost: Int = 15

  /**
   * Gets the mana cost of the Fire spell.
   *
   * @return The mana cost of the spell.
   */
  override def getCost: Int = cost

  /**
   * Activates the Fire spell on the target character.
   *
   * This method calculates the damage based on the caster's attack power, reduces the target's life accordingly,
   * and deducts the mana cost from the caster. There is also a small chance (20%) to apply a burn effect.
   *
   * @param target The character on whom the spell is to be cast.
   * @param mage   The magic player casting the spell.
   */
  override def activateSpell(target: Character, mage: AbstractMagicPlayer): Unit = {
    val damage = mage.getAttack
    
    target.setLife( - damage)
    
    val rand = new Random()
    val res = rand.nextInt(10)
    
    if(res == 0 || res == 1){
      //add burnt
    }

    mage.setMana( - getCost )
  }
}
