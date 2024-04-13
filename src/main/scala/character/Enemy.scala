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
class Enemy(val name: String, var life: Int, var attack: Int, var defense: Int, var weight: Int) extends Character {

  /** Checks if the enemy is defeated.
   *
   * Returns `true` if the enemy's life points are zero or less, indicating defeat.
   * Returns `false` otherwise.
   *
   * @return `true` if the enemy is defeated, `false` otherwise.
   */
  override def isDefeated: Boolean = life <= 0
  
  
}
