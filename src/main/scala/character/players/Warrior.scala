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
  
  

  override def equals(other: Any): Boolean = {
    if (other.isInstanceOf[Warrior]) {
      val warrior1 = other.asInstanceOf[Warrior]
      name == warrior1.getName && life == warrior1.getLife && defense == warrior1.getDefense && weight == warrior1.getWeight
    } else {
      false
    }
  }

  override def toString: String = {
    s"Warrior($name, $life, $defense, $weight)"
  }

  def equip(newWeapon: EquippableByWarrior): Unit = {
    //si llegó hasta aqui es valido el equipar
    super.validEquip(Some(newWeapon.toWeapon))
  }
}
