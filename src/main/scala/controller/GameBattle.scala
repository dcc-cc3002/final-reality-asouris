package controller

import character.Enemy
import party.Party
import character.Character
import weapon.Weapon

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

/**
 * Represent a Battle
 *
 * @param _party the playable characters
 * @param _enemies the enemies
 * @param _weapons a map with the player weapons
 */
class GameBattle (private val _party : Party, private val _enemies: ArrayBuffer[Character], private val _weapons : mutable.Map[Character, ArrayBuffer[Weapon]]){

  /**
   * Inits a game
   */
  def run() : Unit = {
    print("Battle initiated\n")
    val controller = new GameController(_party, _enemies, _weapons)
    while(!controller.checkFinished()) {
      print("Both teams are alive\n")
      controller.update()
      print("Checking battle condition\n")
    }
    print("One team was defeated\n")

    controller.displayEndMessage()
  }
  
  
}
