package character

import character.players.Player
import exceptions.BadBehaviourException

/** Represent an enemy.
  *
  * An enemy is a character controlled by the computer
  *
  * @param name
  *   Name of the enemy.
  * @param maxLife
  *   The max amount of life 
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
class Enemy(name: String, maxLife: Int, life: Int, private var attack: Int, defense: Int, weight: Int) 
  extends AbstractCharacter(name, maxLife, life, defense, weight) {
  require(attack >= 1)

  /**
   * Retrieves the attack value of the enemy.
   *
   * @return The attack value of the enemy.
   */
  def getAttack : Int = attack

  /**
   * Attacks a player, causing damage based on the enemy's attack value.
   *
   * @param player The player to be attacked.
   */
  override def attackPlayer(player: Player): Unit = {
    player.receiveAttack(this.attack)
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
        name == enemy1.getName && maxLife == enemy1.getMaxLife && life == enemy1.getLife && defense == enemy1.getDefense && weight == enemy1.getWeight
      case _ =>
        false
  }

  /**
   * Returns a string representation of this enemy.
   *
   * @return A string representation containing the enemy's properties.
   */
  override def toString: String = {
    s"Enemy($name, $maxLife, $life, $attack, $defense, $weight)"
  }

  /**
   * Overrides the attackEnemy method from the Character trait.
   * This method throws an exception, since an enemy cannot attack another enemy
   *
   * @param enemy The enemy to be attacked.
   * @throws BadBehaviourException Since an enemy cannot attack another enemy
   */
  override def attackEnemy(enemy: Enemy): Unit = {
    throw BadBehaviourException("An enemy cannot attack another enemy")
  }

  /**
   * Gets the action bar for the character, in case of an enemy this is its weight
   *
   * @return Action bar of the Enemy
   */
  override def getActionBar: Double = {
    this.getWeight
  }
  
}
