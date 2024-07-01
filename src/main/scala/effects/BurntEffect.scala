package effects

import character.Character

class BurntEffect(val damage : Int) extends Effect {
  var duration = 3

  override def apply(character: Character): Boolean = {

    if (duration <= 1) {
      character.setLife(-(damage / 2))
      false
    }
    else {
      character.setLife(-(damage / 2))
      duration -= 1
      true
    }
  }
  
  
}
