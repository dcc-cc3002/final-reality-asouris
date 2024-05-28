package spells

import character.Enemy
import character.players.{AbstractMagicPlayer, Player}
import spells.traits.LightSpell

class Poison extends LightSpell{

  def activateSpell(target: Enemy, mage: AbstractMagicPlayer): Unit = {
    //Poison
    mage.setMana(-30)
  }

}
