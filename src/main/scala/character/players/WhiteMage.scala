package character.players
import character.players.MagicPlayer
import character.players.Player
import weapon.Weapon


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
  * @param mana
  *   The magic pointsof the character
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
    var magicPoints: Int
) extends Player(name, life, defense, weight) with MagicPlayer {

  /**
   * Equips a weapon to the White Mage character.
   *
   * @param weapon The weapon to be equipped.
   */
  override def equipWeapon(weapon: Weapon): Unit = ???
}
