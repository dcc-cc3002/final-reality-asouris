package spells

import character.players.{AbstractMagicPlayer, Player}
import spells.traits.LightSpell
import character.Character

class Healing extends AbstractSpell with LightSpell{
  
  private val cost : Int = 15

  override def getCost: Int = cost
  
  override def activateSpell(target: Character, mage: AbstractMagicPlayer): Unit = {
    val current = target.getLife
    val recover = (target.getMaxLife*0.3).toInt
    
    target.setLife(recover)
    
    mage.setMana(-getCost)
  }

}
