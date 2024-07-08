package effects

import character.Character

/**
 * Represents the burnt effect
 * @param damage damage that depends on the caster
 */
class BurntEffect(val damage : Int) extends Effect {
  /** Duration of the effect in turns */
  var duration = 3

  /**
   * Applies the effect to a character
   * @param character victim
   *  @return true if applied, false otherwise
   */
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
  
  /** Overrides toString */
  override def toString : String = {
    s"Burnt($duration)"
  }
  
  
}
