package character.players
import character.players.Player
import character.players.traits.SwordUser
import character.players.traits.BowUser
import character.players.traits.WandUser

/** Represents a Ninja.
  *
  * A Ninja is a playable character
  *
  * @param name
  *   The name of the character
  * @param life
  *   The life of the character
  * @param defense
  *   The defense of the character
  * @param weight
  *   The weight of the character
  * @param weapon
  *   The weapon of the character
  *
  * @constructor Creates a new Ninja character with the specified properties.
  *
  * @author
  *   asouris
  */
class Ninja(
    name: String,
    life: Int,
    defense: Int,
    weight: Int
) extends Player(name, life, defense, weight) with SwordUser with BowUser with WandUser{

  override def equals(other: Any): Boolean = {
    if (other.isInstanceOf[Ninja]) {
      val ninja1 = other.asInstanceOf[Ninja]
      name == ninja1.name && life == ninja1.life && defense == ninja1.defense && weight == ninja1.weight
    } else {
      false
    }
  }

  override def toString: String = {
    s"Ninja($name, $life, $defense, $weight)"
  }

}