package spells

import character.Enemy
import character.players.{AbstractMagicPlayer, Player}
import spells.traits.LightSpell
import character.Character

class Paralysis extends AbstractSpell with LightSpell{
  
  private val cost : Int = 25

  override def getCost: Int = cost
  
  override def activateSpell(target: Character, mage: AbstractMagicPlayer): Unit = {
    //Paralysis
    mage.setMana(-getCost)
  }
}
