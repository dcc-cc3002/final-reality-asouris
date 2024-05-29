package spells

import character.Enemy
import character.players.{AbstractMagicPlayer, Player}
import spells.traits.LightSpell
import character.Character

class Poison extends AbstractSpell with LightSpell{

  private val cost : Int = 30

  override def getCost: Int = cost

  override def activateSpell(target: Character, mage: AbstractMagicPlayer): Unit = {
    //Poison
    mage.setMana(-getCost)
  }


}
