package effects

import character.Character

class ParalyzeEffect(val damage : Int) extends Effect {
  var duration = 1

  override def apply(character: Character): Boolean = {
    print("Character is paralyze for this turn\n")
    
    if(duration <= 1){
      character.setParalyzed(false)
      false
    }
    else{
      character.setParalyzed(true)
      duration -= 1
      print(s"Paralyze has $duration more turns\n")
      true
    }
  }


  override def toString: String = {
    s"Paralyze($duration)"
  }
}
