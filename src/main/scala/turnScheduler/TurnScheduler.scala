package turnScheduler

import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.Queue
import scala.collection.mutable.PriorityQueue
import scala.collection.mutable.Map
import character.Character
import exceptions.NoneException

import scala.collection.mutable

/** A class to manage the turn scheduling of players.
 * This class maintains a map of players and their current value for their actionBar
 * It also has a queue to determine the order of upcoming turns.
 * 
 * @author asouris
 */

class TurnScheduler {

  /** A map of players and their current value for their actionBar*/
  private var characters: mutable.Map[Character, Double] = mutable.Map[Character, Double]()
  /** A queue of players and their respective turn orders. */
  private val nextTurns = new mutable.Queue[Character]
  
  def atLeastOneTurn : Boolean = {
    nextTurns.nonEmpty
  }

  /**
   * Gets the map containing players and their action bars
   * @return A map containing players and their action bars
   */
  def getCharacters : mutable.Map[Character, Double] = characters

  /**
   * Adds a new character to the turn scheduler.
   *
   * @param character The player to add to the scheduler.
   */
  def addCharacter(character : Character) : Unit = {
    characters += (character -> 0)
  }

  /**
   * Removes a character from the turn scheduler.
   *
   * @param character The player to remove from the scheduler.
   */
  def removeCharacter(character : Character) : Unit = {
    characters -= character
  }

  /**
   * Gets the maximum action bar value among all characters.
   *
   * @return An Option containing the maximum action bar value if characters exist, otherwise None.
   */
  def getMaximum : Double = {
    if (characters.isEmpty){
      0
    }
    else{
      characters.maxBy(_._2)._2
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
   * This function also checks if any character filled their actionBar, if so, they are added to
   * the ready list. If more than 1 character filled its actionBar at the same time, the one with the most
   * advantage over its own maximum value of actionBar goes first.
   *
   * @param amount The amount by which to increase the action bar value.
   */
  def increaseActionBar(amount : Int) : Unit = {

    def order(character: Character) : Double = {
      characters.get(character) match {
        case Some(value) =>
          value - character.getActionBar
        case None => throw NoneException("Value is None")
      }
    }
    // 0- 20 = -20
    // 0- 6 = -6 este va primero
    val readyForTurn = mutable.PriorityQueue[Character]()(Ordering.by(order))

    characters.transform((key, value) => {
      if (!isReady(key) && !key.isDefeated) {
        val actionBar = key.getActionBar
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
      characters(next) = next.getActionBar
      nextTurns.enqueue(next)
    }
  }

  /**
   * Checks if a character is ready to take a turn.
   *
   * @param character The player to check.
   * @return True if the character is ready, otherwise false.
   */
  def isReady(character: Character): Boolean = {
    characters.get(character) match {
      case Some(value) =>
        value >= character.getActionBar
      case None => throw NoneException("Value is None")
    }
  }

  /**
   * Gets a list of characters ready to take their turn.
   *
   * @return An ArrayBuffer containing characters ready to take their turn.
   */
  def getReady : ArrayBuffer[Character] = {
    val ready: ArrayBuffer[Character] = new ArrayBuffer[Character]()
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
  def nextCharacter : Character = {
    if(nextTurns.nonEmpty){
      nextTurns.dequeue
    }
    else{
      throw NoneException("Queue is Empty")
    }
  }

  /**
   * turns characters action bar to 0
   * @param character to be affected 
   */
  def resetCharacterActionBar(character: Character) : Unit = {
    characters(character) = 0
  }

}
