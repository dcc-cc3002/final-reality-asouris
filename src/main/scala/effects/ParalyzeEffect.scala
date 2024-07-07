package effects

import character.Character

class ParalyzeEffect(val damage : Int) extends Effect {
  var duration = 1

  override def apply(character: Character): Boolean = {
    print("Character is paralyze for this turn\n")
    
    character.setParalyzed(true)
    duration -= 1
    false
  }


  override def toString: String = {
    s"Paralyze($duration)"
  }
}
