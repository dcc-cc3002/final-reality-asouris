package character.players

import character.players.traits.SwordUser
import character.players.traits.AxeUser
import character.players.traits.BowUser

/** Represents a Warrior.
  *
  * A Warrior is a playable character
  *
  * @param name
  *   The name of the character.
  * @param life
  *   The life of the character.
  * @param defense
  *   The defense of the character.
  * @param weight
  *   The weight of the character.
  * @param weapon
  *   The weapon of the character
  *
  * @constructor Creates a new warrior character with the specified properties.
  *
  * @author
  *   asouris
  */
class Warrior(
    name: String,
    life: Int,
    defense: Int,
    weight: Int
) extends Player(name, life, defense, weight) with SwordUser with AxeUser with BowUser{

  override def equals(other: Any): Boolean = {
    if (other.isInstanceOf[Warrior]) {
      val warrior1 = other.asInstanceOf[Warrior]
      name == warrior1.name && life == warrior1.life && defense == warrior1.defense && weight == warrior1.weight
    } else {
      false
    }
  }

  override def toString: String = {
    s"Warrior($name, $life, $defense, $weight)"
  }
}
