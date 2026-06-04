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

  /**
   * Checks whether this ninja is equal to another object.
   *
   * @param other The object to compare with.
   * @return True if the objects are equal, false otherwise.
   */
  override def equals(other: Any): Boolean = {
    other match
      case ninja1: Ninja =>
        name == ninja1.getName && life == ninja1.getLife && defense == ninja1.getDefense && weight == ninja1.getWeight
      case _ =>
        false
  }

  /**
   * Returns a string representation of this ninja.
   *
   * @return A string representation containing the ninja's properties.
   */
  override def toString: String = {
    s"Ninja($name, $life, $defense, $weight)"
  }

  /**
   * Equips a new weapon to the ninja via the method validEquip.
   * This method overrides the one declared in Player.
   *
   * @param newWeapon The weapon to be equipped.
   */
  def equip(newWeapon: EquippableByNinja): Unit = {
    super.validEquip(newWeapon.toWeapon)
  }

}