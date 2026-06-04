package character

/** Represent an enemy.
  *
  * An enemy is a character controlled by the computer
  *
  * @param name
  *   Name of the enemy.
  * @param life
  *   Amount of life left
  * @param attack
  *   Damage made per attack
  * @param defense
  *   Something
  * @param weight
  *   weight of the enemy
  * @constructor
  *   Creates a new Enemy with the specified properties.
  * @author
  *   asouris
  */
class Enemy(name: String, life: Int, private var attack: Int, defense: Int, weight: Int) 
  extends AbstractCharacter(name, life, defense, weight) {
  require(attack >= 1)

  /**
   * Retrieves the attack value of the enemy.
   *
   * @return The attack value of the enemy.
   */
  def getAttack : Int = attack

  /**
   * Attacks another character, causing damage based on the enemy's attack value.
   *
   * @param character The character to be attacked.
   */
  override def attackCharacter(character: Character): Unit = {
    character.receiveAttack(this.attack)
  }

  /**
   * Compares this enemy with another object for equality.
   *
   * Two enemies are considered equal if they have the same name, life points, defense, and weight.
   *
   * @param other The object to compare with.
   * @return `true` if the objects are equal, `false` otherwise.
   */
  override def equals(other: Any): Boolean = {
    other match
      case enemy1: Enemy =>
        name == enemy1.getName && life == enemy1.getLife && defense == enemy1.getDefense && weight == enemy1.getWeight
      case _ =>
        false
  }

  /**
   * Returns a string representation of this enemy.
   *
   * @return A string representation containing the enemy's properties.
   */
  override def toString: String = {
    s"Enemy($name, $life, $attack, $defense, $weight)"
  }
  
  
}
