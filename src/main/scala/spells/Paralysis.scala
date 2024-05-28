package spells

import character.Enemy
import character.players.{AbstractMagicPlayer, Player}
import spells.traits.LightSpell

class Paralysis extends LightSpell{
  def activateSpell(target: Enemy, mage: AbstractMagicPlayer): Unit = {
    //Paralysis
    mage.setMana(-25)
  }
}
