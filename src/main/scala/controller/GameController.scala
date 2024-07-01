package controller
import character.Character
import character.Enemy
import character.players.WhiteMage
import controller.states.{BeginningTurn, GameState, InitialState, SettingTurns}
import party.Party
import spells.traits.Spell
import turnScheduler.TurnScheduler
import weapon.Weapon

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

class GameController(private val _party : Party, private val _enemies: ArrayBuffer[Character], private val _weapons : mutable.Map[Character, ArrayBuffer[Weapon]]) {

  private var _state: GameState = new InitialState
  private val _scheduler : TurnScheduler = new TurnScheduler
  private val _k : Int = 20

  var currentTurn : Option[Character] = None

  init()
  /**
   * Inicia una partida
   */
  private def init() : Unit = {
    _state = new SettingTurns
    initializeScheduler()
  }
  
  private def initializeScheduler() : Unit = {
    for(member <- _party.getMembers) {
      member.setTeam(_party.getMembers)
      _scheduler.addCharacter(member)
    }
    for(enemy <- _enemies) {
      enemy.setTeam(_enemies)
      _scheduler.addCharacter(enemy)
    }
  }
  
  def getEnemies : ArrayBuffer[Character] = _enemies
  def getPlayers : ArrayBuffer[Character] = _party.getMembers
  
  def getWeapons : mutable.Map[Character, ArrayBuffer[Weapon]] = _weapons
  

  /**
   * Checkea si la partida terminó
   * @return
   */
  def checkFinished() : Boolean = {
    allAlliesDead(_party.getMembers(0)) || allAlliesDead(_enemies(0))
  }

  /**
   * if all enemy are defeated return true
   */
  //private def win() : Boolean = {}
  /** if all allies are defeated returns true */
  //private def lose() : Boolean = {}

  def update() : Unit = {
    _state.update(this)
  }

  /**
   * increases actionBar in scheduler
   */
  def increaseActionBar() : Unit = _scheduler.increaseActionBar(_k)

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

  def partyDefeated : Boolean = {
    _party.isDefeated
  }

  def enemiesDefeated : Boolean = {
    _enemies.forall(_.isDefeated)
  }

  /**
   * handles weather new turns need to be set or not
   * can be called from beginningTurn or endingTurn
   */
  def handlingNewTurn() : Unit = {
    if(!this.areTurns()){
      this.setState(new SettingTurns)
    }
    else{
      this.setState(new BeginningTurn)
    }
  }
  
  def allAlliesDead(character : Character): Boolean = {
    character.getTeam.forall(_.isDefeated)
  }
  
  def resetActionBar(character: Character): Unit = {
    _scheduler.resetCharacterActionBar(character)
  }
  
  def getSpells(mage : Character): Array[Spell] = {
    mage.getSpells(mage)
  }
  
  
  def getSpellTargets(spell : Spell, character : Character) : ArrayBuffer[Character] = {
    spell.getTargets(this, character)  
  }

  def displayEndMessage() : Unit = {
    if(win()){
      print("The party has won! Congratulations!")
    }
    else{
      print("You have lost.")
    }
  }

  def win() : Boolean = {
    getPlayers.forall(_.isDefeated)
  }



}
