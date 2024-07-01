package effects

import character.Character

class PoisonEffect(val damage : Int) extends Effect{
  var duration = 4

  override def apply(character: Character): Boolean = {

    if (duration <= 1) {
      character.setLife(-(damage/3))
      false
    }
    else {
      character.setLife(-(damage/3))
      duration -= 1
      true
    }
  }
}
