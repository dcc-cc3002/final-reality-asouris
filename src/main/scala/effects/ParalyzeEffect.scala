package effects

import character.Character

/**
 * Represents the paralyze effect
 * @param damage its not relevant to this effect but for all other effects
 */
class ParalyzeEffect(val damage : Int) extends Effect {
  /** Duration of the effect in turns */
  var duration = 1

  /**
   * Applies the effect to a character
   * @param character victim
   *  @return true if applied, false otherwise
   */
  override def apply(character: Character): Boolean = {
    print("Character is paralyze for this turn\n")
    
    character.setParalyzed(true)
    duration -= 1
    false
  }


  /** Overrides toString */
  override def toString: String = {
    s"Paralyze($duration)"
  }
}
