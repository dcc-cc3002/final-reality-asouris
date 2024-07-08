package controller
import character.Character
import character.Enemy
import character.players.WhiteMage
import controller.states.{BeginningTurn, GameState, SettingTurns}
import party.Party
import spells.traits.Spell
import turnScheduler.TurnScheduler
import weapon.Weapon

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

/**
 * Represents the controller for a game
 * @param _party the playable characters
 * @param _enemies the enemies
 * @param _weapons a map with the player weapons
 */
class GameController(private val _party : Party, private val _enemies: ArrayBuffer[Character], private val _weapons : mutable.Map[Character, ArrayBuffer[Weapon]]) {

  /**
   * Holds the current State of the game
   */
  private var _state: GameState = _
  /**
   * Holds the scheduler for the game
   */
  private val _scheduler : TurnScheduler = new TurnScheduler
  /**
   * Value for increasing the actionBars each iteration
   */
  private val _k : Int = 20
  /**
   * Holds current playing character
   */
  var currentTurn : Option[Character] = None

  init()
  /**
   * Starts a game
   */
  private def init() : Unit = {
    print("Controller initiated\n")
    _state = new SettingTurns
    initializeScheduler()
  }

  /**
   * Initialize the scheduler with the characters
   */
  private def initializeScheduler() : Unit = {
    for(member <- _party.getMembers) {
      member.setTeam(_party.getMembers)
      _scheduler.addCharacter(member)
    }
    for(enemy <- _enemies) {
      enemy.setTeam(_enemies)
      _scheduler.addCharacter(enemy)
    }
    
    print("Scheduler set\n")
  }

  /**
   * Returns the enemies
   * @return The enemies
   */
  def getEnemies : ArrayBuffer[Character] = _enemies

  /**
   * Returns the players
   * @return The players
   */
  def getPlayers : ArrayBuffer[Character] = _party.getMembers

  /**
   * Returns the weapon assignation
   * @return Weapon map
   */
  def getWeapons : mutable.Map[Character, ArrayBuffer[Weapon]] = _weapons

  /**
   * Checkea si la partida terminó
   * @return
   */
  def checkFinished() : Boolean = {
    allAlliesDead(_party.getMembers(0)) || allAlliesDead(_enemies(0))
  }

  /**
   * Executes the state update function
   */
  def update() : Unit = {
    _state.update(this)
  }

  /**
   * increases actionBar in scheduler
   */
  def increaseActionBar() : Unit = {
    print("Increasing action bar\n")
    _scheduler.increaseActionBar(_k)
  }

  /**
   * returns true if there is at least one character ready to play
   * @return
   */
  def areTurns() : Boolean = {
    _scheduler.atLeastOneTurn
  }

  /**
   * updates the variable _state
   * @param state the new current state
   */
  def setState(state : GameState) : Unit = _state = state

  /**
   * gets the next ready character
   * @return the next character
   */
  def nextTurn() : Character = {
    _scheduler.nextCharacter
  }

  /**
   * Tells if the party was defeated
   * @return true if party was defeated, false otherwise
   */
  def partyDefeated : Boolean = {
    _party.isDefeated
  }

  /**
   * Tells if the enemies were defeated
   *
   * @return true if enemies were defeated, false otherwise
   */
  def enemiesDefeated : Boolean = {
    _enemies.forall(_.isDefeated)
  }

  /**
   * Tells if all allies of a character are dead
   * @param character character to check
   * @return true if all allies are dead, false otherwise
   */
  def allAlliesDead(character : Character): Boolean = {
    character.getTeam.forall(_.isDefeated)
  }

  /**
   * Sets actionBar of a character to 0
   * @param character character to modify
   */
  def resetActionBar(character: Character): Unit = {
    _scheduler.resetCharacterActionBar(character)
  }

  /**
   * Returns all available spells for a mage
   * @param mage mage to check
   * @return list of spells
   */
  def getSpells(mage : Character): Array[Spell] = {
    mage.getSpells(mage)
  }

  /**
   * Returns An array with possible targets of a spell
   * @param spell spell to check
   * @param character caster
   * @return array with characters
   */
  def getSpellTargets(spell : Spell, character : Character) : ArrayBuffer[Character] = {
    spell.getTargets(this, character)  
  }

  /**
   * Displays a massage at the end of a game depending on the result
   */
  def displayEndMessage() : Unit = {
    if(win()){
      print("The party has won! Congratulations!")
    }
    else{
      print("You have lost.")
    }
  }

  /**
   * Tells if the game is won
   * @return true if the game was won, false otherwise
   */
  def win() : Boolean = {
    getEnemies.forall(_.isDefeated)
  }

  /**
   * Returns the current state of the controller
   * @return A state
   */
  def getState : GameState = _state



}
