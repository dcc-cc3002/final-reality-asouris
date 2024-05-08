package character.players
import weapon.traits.EquippableByNinja

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
) extends AbstractPlayer(name, life, defense, weight){

  override def equals(other: Any): Boolean = {
    if (other.isInstanceOf[Ninja]) {
      val ninja1 = other.asInstanceOf[Ninja]
      name == ninja1.getName && life == ninja1.getLife && defense == ninja1.getDefense && weight == ninja1.getWeight
    } else {
      false
    }
  }

  override def toString: String = {
    s"Ninja($name, $life, $defense, $weight)"
  }

  def equip(newWeapon: EquippableByNinja): Unit = {
    super.validEquip(Some(newWeapon.toWeapon))
  }

}