package spells

import character.players.{AbstractMagicPlayer, Player}
import spells.traits.LightSpell

class Healing extends LightSpell{
  def activateSpell(target: Player, mage: AbstractMagicPlayer): Unit = {
    val current = target.getLife
    val recover = (target.getMaxLife*0.3).toInt
    
    target.setLife(recover)
    
    mage.setMana(-15)
  }

}
