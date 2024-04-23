package character.players

import character.players.Player
import character.players.MagicPlayer
import character.players.traits.SwordUser
import character.players.traits.WandUser
import character.players.traits.StaffUser

/** Represents a BlackMage.
  *
  * A BlackMage is a playable character.
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
  *   The magic points of the character
  *
  * @constructor Creates a new Black Mage character with the specified properties.
  *
  * @author
  *   asouris
  */
class BlackMage(
    name: String,
    life: Int,
    defense: Int,
    weight: Int,
    var magicPoints: Int
) extends Player(name, life, defense, weight) with MagicPlayer with SwordUser with WandUser with StaffUser{

  override def equals(other: Any): Boolean = {
    if (other.isInstanceOf[BlackMage]) {
      val blackMage1 = other.asInstanceOf[BlackMage]
      name == blackMage1.name && life == blackMage1.life && defense == blackMage1.defense && weight == blackMage1.weight && magicPoints == blackMage1.magicPoints
    } else {
      false
    }
  }

  override def toString: String = {
    s"BlackMage($name, $life, $defense, $weight, $magicPoints)"
  }

}
