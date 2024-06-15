package controller

import character.Enemy
import party.Party

import scala.collection.mutable.ArrayBuffer

class GameBattle (private val party : Party, private val enemies: ArrayBuffer[Enemy]){
  
  def run() : Unit = {
    val controller = new GameController(party, enemies)
    while(!controller.checkFinished()) {
      controller.update()
    }
    
  }
  
  
}
