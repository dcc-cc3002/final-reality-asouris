package effects

import character.Character

/**
 * Represents a poison effect
 * @param damage damage that depends on the caster
 */
class PoisonEffect(val damage : Int) extends Effect{
  /** Duration of the effect in turns */
  var duration = 4

  /**
   * Applies the effect to a character
   *
   * @param character victim
   * @return true if applied, false otherwise
   */
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

  /** Overrides toString */
  override def toString: String = {
    s"Poison($duration)"
  }
}
