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
 * @param weapon
 *    The weapon of the character
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
    magicPoints: Int
) extends AbstractMagicPlayer(name, life, defense, weight, magicPoints){

  override def equals(other: Any): Boolean = {
    if (other.isInstanceOf[WhiteMage]) {
      val whiteMage1 = other.asInstanceOf[WhiteMage]
      name == whiteMage1.name && life == whiteMage1.life && defense == whiteMage1.defense && weight == whiteMage1.weight && magicPoints == whiteMage1.magicPoints
    } else {
      false
    }
  }

  override def toString: String = {
    s"WhiteMage($name, $life, $defense, $weight, $magicPoints)"
  }

  def equip(newWeapon: EquippableByWhiteMage): Unit = {
    //si llegó hasta aqui es valido el equipar
    super.validEquip(Some(newWeapon.toWeapon))
  }
}
