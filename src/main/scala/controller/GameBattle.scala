package controller

import character.Enemy
import party.Party
import character.Character
import weapon.Weapon

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

class GameBattle (private val _party : Party, private val _enemies: ArrayBuffer[Character], private val _weapons : mutable.Map[Character, ArrayBuffer[Weapon]]){
  
  def run() : Unit = {
    val controller = new GameController(_party, _enemies, _weapons)
    while(!controller.checkFinished()) {
      controller.update()
    }

    controller.displayEndMessage()
  }
  
  
}
