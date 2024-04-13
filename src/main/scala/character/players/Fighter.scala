package character.players
import character.players.Player
import weapon.Weapon

/** Represents a Fighter.
  *
  * A Fighter is a playable character
  *
  * @param name
  *   The name of the character.
  * @param life
  *   The life of the character.
  * @param defense
  *   The defense of the character.
  * @param weight
  *   The weight of the character.
  *
  * @constructor Creates a new fighter character with the specified properties.
  *
  * @author
  *   asouris
  */
class Fighter(
    name: String,
    life: Int,
    defense: Int,
    weight: Int
) extends Player(name, life, defense, weight) {

  /**
   * Equips a weapon to the fighter character.
   *
   * @param weapon The weapon to be equipped.
   */
  override def equipWeapon(weapon: Weapon): Unit = ???
}
