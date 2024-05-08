package turnScheduler

import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.Queue
import scala.collection.mutable.PriorityQueue
import scala.collection.mutable.Map
import character.players.Player
import exceptions.NoneException

import scala.collection.mutable

/** A class to manage the turn scheduling of players.
 * This class maintains a map of players and their current value for their actionBar
 * It also has a queue to determine the order of upcoming turns.
 */

class TurnScheduler {

  /** A map of players and their current value for their actionBar*/
  private val characters: mutable.Map[Player, Double] = mutable.Map[Player, Double]()
  /** A map of players and their respective turn orders. */
  private val nextTurns = new mutable.Queue[Player]

  def getCharacters : mutable.Map[Player, Double] = characters

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
    characters -= character
  }

  /**
   * Gets the maximum action bar value among all characters.
   *
   * @return An Option containing the maximum action bar value if characters exist, otherwise None.
   */
  def getMaximum : Option[Double] = {
    if (characters.isEmpty){
      None
    }
    else{
      Some(characters.maxBy(_._2)._2)
    }
  }

  /**
   * Resets the action bar of all characters.
   */
  def resetActionBar() : Unit = {
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
          print(value, amount, character.getWeight, character.getWeapon.getWeight, "\n")
          print(character, (value+amount) - (character.getWeight + character.getWeapon.getWeight * 0.5), "\n")
          value - (character.getWeight + character.getWeapon.getWeight * 0.5)
        case None => throw NoneException("Value is None")
      }
    }
    // 0- 20 = -20
    // 0- 6 = -6 este va primero
    val readyForTurn = mutable.PriorityQueue[Player]()(Ordering.by(order))

    characters.transform((key, value) => {
      if (!isReady(key)) {
        val actionBar = key.getWeight + key.getWeapon.getWeight * 0.5
        if(value + amount >= actionBar){
          readyForTurn.enqueue(key)
          value
        }
        else{value + amount}
      }
      else {
        value
      }

    })

    while(readyForTurn.nonEmpty){
      val next = readyForTurn.dequeue()
      characters(next) = next.getWeight + next.getWeapon.getWeight * 0.5
      nextTurns.enqueue(next)
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
        value >= character.getWeight + character.getWeapon.getWeight * 0.5
      case None => throw NoneException("Value is None")
    }
  }

  /**
   * Gets a list of characters ready to take their turn.
   *
   * @return An ArrayBuffer containing characters ready to take their turn.
   */
  def getReady : ArrayBuffer[Player] = {
    val ready: ArrayBuffer[Player] = new ArrayBuffer[Player]()
    while(nextTurns.nonEmpty) {
      ready.addOne(nextTurns.dequeue)
    }
    ready
  }

  /**
   * Gets the next character scheduled to take a turn.
   *
   * @return An Option containing the next character if available, otherwise None.
   */
  def nextCharacter : Player = {
    if(nextTurns.nonEmpty){
      nextTurns.front
    }
    else{
      throw NoneException("Queue is Empty")
    }
  }

}
