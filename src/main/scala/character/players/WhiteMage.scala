package character.players
import character.players.Player
import weapon.traits.EquippableByWhiteMage


/** Represents a WhiteMage.
  *
  * A WhiteMage is a playable character.
  *
  * @param name
  *   The name of the character
  * @param life
  *   The life of the character
  * @param defense
  *   The defense of the character
  * @param weight
  *   The weight of the character
  * @param magicPoints
  *   The magic points of the character
  *
  * @constructor Creates a new White Mage character with the specified properties.
  *
  * @author
  *   asouris
  */
class WhiteMage(
    name: String,
    life: Int,
    defense: Int,
    weight: Int,
    magicPoints: Int
) extends AbstractMagicPlayer(name, life, defense, weight, magicPoints){

  /**
   * Checks whether this white mage is equal to another object.
   *
   * @param other The object to compare with.
   * @return True if the objects are equal, false otherwise.
   */
  override def equals(other: Any): Boolean = {
    other match
      case whiteMage1: WhiteMage =>
        name == whiteMage1.getName && life == whiteMage1.getLife && defense == whiteMage1.getDefense && weight == whiteMage1.getWeight && magicPoints == whiteMage1.getMagicPoints
      case _ =>
        false
  }

  /**
   * Returns a string representation of this white mage.
   *
   * @return A string representation containing the white mage's properties.
   */
  override def toString: String = {
    s"WhiteMage($name, $life, $defense, $weight, $magicPoints)"
  }

  /**
   * Equips a new weapon to the white mage via the method validEquip.
   * This method overrides the one declared in Player.
   *
   * @param newWeapon The weapon to be equipped.
   */
  def equip(newWeapon: EquippableByWhiteMage): Unit = {
    super.validEquip(newWeapon.toWeapon)
  }
}
