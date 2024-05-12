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
  
  def getAttack : Int = attack

  /** Checks if the enemy is defeated.
   *
   * Returns `true` if the enemy's life points are zero or less, indicating defeat.
   * Returns `false` otherwise.
   *
   * @return `true` if the enemy is defeated, `false` otherwise.
   */
    
  override def attackCharacter(character: Character): Unit = {
    character.receiveAttack(this.attack)
  }

  override def equals(other: Any): Boolean = {
    other match
      case enemy1: Enemy =>
        name == enemy1.getName && life == enemy1.getLife && defense == enemy1.getDefense && weight == enemy1.getWeight
      case _ =>
        false
  }

  override def toString: String = {
    s"Enemy($name, $life, $attack, $defense, $weight)"
  }
  
  
}
