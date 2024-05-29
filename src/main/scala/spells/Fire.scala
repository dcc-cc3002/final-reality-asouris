package spells

import character.Enemy
import character.players.{AbstractMagicPlayer, Player}
import spells.traits.DarkSpell
import character.Character

import scala.util.Random

class Fire extends AbstractSpell with DarkSpell{
  
  private val cost: Int = 15

  override def getCost: Int = cost
  
  override def activateSpell(target: Character, mage: AbstractMagicPlayer): Unit = {
    val damage = mage.getAttack
    
    target.setLife( - damage)
    
    val rand = new Random()
    val res = rand.nextInt(10)
    
    if(res == 0 || res == 1){
      print("Burnt")
    }

    mage.setMana( - getCost )
  }
}
