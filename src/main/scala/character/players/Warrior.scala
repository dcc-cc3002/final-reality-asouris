package character.players

import exceptions.WeaponException
import weapon.Weapon

/** Represents a Warrior.
  *
  * A Warrior is a playable character
  *
  * @param name
  *   The name of the character.
  * @param maxLife
  *   The max amount of life 
  * @param life
  *   The life of the character.
  * @param defense
  *   The defense of the character.
  * @param weight
  *   The weight of the character.
  * @constructor Creates a new warrior character with the specified properties.
  * @author
  *   asouris
  */
class Warrior(
    name: String,
    maxLife: Int,
    life: Int,
    defense: Int,
    weight: Int
) extends AbstractPlayer(name, maxLife, life, defense, weight){


  /**
   * Checks whether this warrior is equal to another object.
   *
   * @param other The object to compare with.
   * @return True if the objects are equal, false otherwise.
   */
  override def equals(other: Any): Boolean = {
    other match
      case warrior1: Warrior =>
        name == warrior1.getName && maxLife == warrior1.getMaxLife && life == warrior1.getLife && defense == warrior1.getDefense && weight == warrior1.getWeight
      case _ =>
        false
  }

  /**
   * Returns a string representation of this warrior.
   *
   * @return A string representation containing the warrior's properties.
   */
  override def toString: String = {
    s"Warrior($name, $maxLife, $getLife, $defense, $weight)"
  }

  /**
   * Equips a new weapon to the warrior via the method validEquip.
   * This method overrides the one declared in Player.
   *
   * @param newWeapon The weapon to be equipped.
   */
  override def equip(newWeapon: Weapon): Unit = {
    if(newWeapon.isEquippableByWarrior) {
      super.validEquip(newWeapon.toWeapon)
    }
    else{
      throw WeaponException(s"$this cannot equip $newWeapon")
    }
  }
}
