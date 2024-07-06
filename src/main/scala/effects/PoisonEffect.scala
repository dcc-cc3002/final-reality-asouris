package effects

import character.Character

class PoisonEffect(val damage : Int) extends Effect{
  var duration = 4

  override def apply(character: Character): Boolean = {
    print("Applying poison...\n")

    if (duration <= 1) {
      character.setLife(-(damage/3))
      false
    }
    else {
      character.setLife(-(damage/3))
      duration -= 1
      print(s"Poison has $duration more turns\n")
      true
    }
  }

  override def toString: String = {
    s"Poison($duration)"
  }
}
