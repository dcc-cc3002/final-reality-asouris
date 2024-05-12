package character.players

import weapon.traits.EquippableByWarrior

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
) extends AbstractPlayer(name, life, defense, weight){


  /**
   * Checks whether this warrior is equal to another object.
   *
   * @param other The object to compare with.
   * @return True if the objects are equal, false otherwise.
   */
  override def equals(other: Any): Boolean = {
    other match
      case warrior1: Warrior =>
        name == warrior1.getName && life == warrior1.getLife && defense == warrior1.getDefense && weight == warrior1.getWeight
      case _ =>
        false
  }

  /**
   * Returns a string representation of this warrior.
   *
   * @return A string representation containing the warrior's properties.
   */
  override def toString: String = {
    s"Warrior($name, $life, $defense, $weight)"
  }

  /**
   * Equips a new weapon to the warrior via the method validEquip.
   * This method overrides the one declared in Player.
   *
   * @param newWeapon The weapon to be equipped.
   */
  def equip(newWeapon: EquippableByWarrior): Unit = {
    super.validEquip(newWeapon.toWeapon)
  }
}
