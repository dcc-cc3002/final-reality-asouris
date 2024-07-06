package effects

import character.Character

class BurntEffect(val damage : Int) extends Effect {
  var duration = 3

  override def apply(character: Character): Boolean = {
    print("Applying Fire...\n")

    if (duration <= 1) {
      character.setLife(-(damage / 2))
      false
    }
    else {
      character.setLife(-(damage / 2))
      duration -= 1
      print(s"Fire has $duration more turns\n")
      true
    }
  }
  
  override def toString : String = {
    s"Burnt($duration)"
  }
  
  
}
