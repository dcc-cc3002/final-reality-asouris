package effects

import character.Character

class ParalyzeEffect(val damage : Int) extends Effect {
  var duration = 1

  override def apply(character: Character): Boolean = {
    
    if(duration <= 1){
      character.setParalyzed(false)
      false
    }
    else{
      character.setParalyzed(true)
      duration -= 1
      true
    }
  }
}
