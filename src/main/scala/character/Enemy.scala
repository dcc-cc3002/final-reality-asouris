package character

import character.players.{AbstractMagicPlayer, Player}
import controller.GameController
import controller.states.GameState
import exceptions.{BadBehaviourException, WeaponException}
import spells.Fire
import spells.traits.Spell
import weapon.Weapon
import scala.util.Random

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
    s"Enemy($name, $maxLife, $getLife, $attack, $defense, $weight)"
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

  /**
   * This method throws a WeaponException indicating since an enemy cannot have a weapon.
   * 
   * @param weapon The weapon to be equipped.
   * @throws WeaponException Since an enemy cannot have a weapon.
   */
  def equip(weapon: Weapon): Unit = {
    throw WeaponException(s"$this cannot equip a weapon")
  }

  /**
   * Unequipps a weapon by removing the player from being the owner of the weapon, then removing the weapon
   * from the equippedWeapon attribute.
   */
  def unequipWeapon(): Unit = throw BadBehaviourException(s"$this cannot unequip a weapon")



  /**
   * returns an array with available actions for the player
   *
   * @return array with options
   */
  def getActions: Array[GameState] = Array()

  /**
   * if character is a mage, returns an array with avaible spells
   * return empty array otherwise
   *
   * @param character
   * @return array with spells
   */
  override def getSpells(character: Character): Array[Spell] = {
    Array()
  }

  /**
   * Provides interface with the user to choose a target and attack
   * @param controller holds information about possible targets
   */
  override def chooseAndAttackTarget(controller: GameController): Unit = {
    print(s"$this choosing target...\n")
    val targets = controller.getPlayers

    val rand = new Random()
    var res = rand.nextInt(targets.length)
    var target = targets(res)
    //while i keep on getting a defeated target
    while(target.isDefeated){
      res = rand.nextInt(targets.length)
      target = targets(res)
    }
    
    

    print(s"$target will be attacked by $attack\n")
    
    targets(res).receiveAttack(this.attack)

    print(s"Attack result: $target\n")
  }

  /**
   * Returns true if the character can be damage by a spell
   *
   * @return
   */
  override def takesSpellDamage: Boolean = true

  
}
