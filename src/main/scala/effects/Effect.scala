package effects

import character.Character

/**
 * Represents an effect
 */

trait Effect {

  /**
   * Applies effect on character. Returns true if it was successfully applied
   * Returns False if it cannot be applied any more
   * @param character victim
   * @return true if applied, false otherwise
   */
  def apply(character: Character) : Boolean

}
