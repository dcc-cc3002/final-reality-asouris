package turnScheduler

import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.Queue
import scala.collection.mutable.PriorityQueue
import scala.collection.mutable.Map
import character.players.Player

/** A class to manage the turn scheduling of players.
 * This class maintains a map of players and their current value for their actionBar
 * It also has a queue to determine the order of upcoming turns.
 */

class TurnScheduler {

  /** A map of players and their current value for their actionBar*/
  val characters = Map[Player, Int]()
  /** A map of players and their respective turn orders. */
  var nextTurns = new Queue[Player]

  /**
   * Adds a new character to the turn scheduler.
   *
   * @param character The player to add to the scheduler.
   */
  def addCharacter(character : Player) : Unit = {
    characters += (character -> 0)
  }

  /**
   * Removes a character from the turn scheduler.
   *
   * @param character The player to remove from the scheduler.
   */
  def removeCharacter(character : Player) : Unit = {
    characters -= (character)
  }

  /**
   * Gets the maximum action bar value among all characters.
   *
   * @return An Option containing the maximum action bar value if characters exist, otherwise None.
   */
  def getMaximum : Option[Int] = {
    if (characters.isEmpty){
      None
    }
    else{
      Some(characters.maxBy(_._2)._2)
    }
  }

  /**
   * Resets the action bar of all characters.
   *
   * @param character The player whose action bar needs to be reset.
   */
  def resetActionBar : Unit = {
    nextTurns.clear()
    characters.transform((key, value) => 0)
  }

  /**
   * Increases the action bar value of all characters by a specified amount.
   *
   * @param amount The amount by which to increase the action bar value.
   */
  def increaseActionBar(amount : Int) : Unit = {

    def order(character: Player) : Double = {
      characters.get(character) match {
        case Some(value) =>
          character.weapon match {
            case Some(weapon) => value - (character.weight + weapon.weight * 0.5)
            case None => 0//add exception
          }
        case None => 0 // add exception
      }
    }
    val readyForTurn = PriorityQueue[Player]()(Ordering.by(order))

    characters.transform((key, value) => {
      if (!isReady(key)) {
        key.weapon match {
          case Some(weapon) => {
            var actionBar = key.weight + weapon.weight * 0.5
            if(value + amount >= actionBar){readyForTurn.enqueue(key)}
            value + amount
          }
          case None => 0//exception
        }
      }
      else {
        value
      }
    })

    while(!readyForTurn.isEmpty){
      nextTurns.enqueue(readyForTurn.dequeue)
    }
  }

  /**
   * Checks if a character is ready to take a turn.
   *
   * @param character The player to check.
   * @return True if the character is ready, otherwise false.
   */
  def isReady(character: Player): Boolean = {
    characters.get(character) match {
      case Some(value) =>
        character.weapon match {
          case Some(weapon) => value >= character.weight + weapon.weight * 0.5
          case None => false //exception
        }
      case None => false // exception
    }
  }

  /**
   * Gets a list of characters ready to take their turn.
   *
   * @return An ArrayBuffer containing characters ready to take their turn.
   */
  def getReady : ArrayBuffer[Player] = {
    val ready: ArrayBuffer[Player] = new ArrayBuffer[Player]()
    while(!nextTurns.isEmpty) {
      ready.addOne(nextTurns.dequeue)
    }
    ready
  }

  /**
   * Gets the next character scheduled to take a turn.
   *
   * @return An Option containing the next character if available, otherwise None.
   */
  def nextCharacter : Option[Player] = {
    if(!nextTurns.isEmpty){
      Some(nextTurns.front)
    }
    else{
      None
    }
  }

}
