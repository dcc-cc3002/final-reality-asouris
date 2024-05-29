package spells.traits

import character.players.{AbstractMagicPlayer, Player}
import character.Character
import exceptions.SpellException

trait Spell {
  
  def getCost: Int

  def activateSpell(target: Character, mage: AbstractMagicPlayer): Unit
}
