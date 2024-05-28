package spells.traits

import character.players.{AbstractMagicPlayer, Player}
import character.Character
import exceptions.SpellException

trait Spell {

  def activateSpell(target: Character, mage: AbstractMagicPlayer): Unit = {
    throw SpellException(s"$this cannot affect $target")
  }
}
