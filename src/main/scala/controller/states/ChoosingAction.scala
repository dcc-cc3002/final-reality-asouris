package controller.states
import controller.GameController
import exceptions.NoneException

import scala.io.StdIn

class ChoosingAction extends GameState{

  //some player choose a weapon a now we need to decide on attack or spell
  //only magical players can do a spell
  override def update(controller: GameController): Unit = {
    
    var actions : Array[GameState] = null

    controller.currentTurn match {
      case Some(character) => actions = character.getActions
      case None => throw NoneException("Something went wrong")
    }
    //map states to number for choosing :)
    if(actions.length > 1){
      print("You can take one of the following actions\nAttacking an enemy (1)\nCasting a spell (2)")
      val selected = StdIn.readInt()
      controller.setState(actions(selected-1))
    }
    else{
      print("You must attack an enemy\n")
      controller.setState(new AttackState)
    }

  }

}
