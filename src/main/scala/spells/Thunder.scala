package spells

import character.Enemy
import character.players.{AbstractMagicPlayer, Player}
import spells.traits.DarkSpell

import scala.util.Random

class Thunder extends DarkSpell {
  def activateSpell(target: Enemy, mage: AbstractMagicPlayer): Unit = {
    val damage = mage.getAttack

    target.setLife(-damage)

    val rand = new Random()
    val res = rand.nextInt(10)

    if (res == 0 || res == 1 || res == 2) {
      print("Paralysis")
    }

    mage.setMana(-20)
  }
}
