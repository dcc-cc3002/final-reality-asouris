package controller.states

import controller.GameController

class SettingTurns extends GameState {

  override def update(controller : GameController) : Unit = {
    print("Updating on SettingTurns\n")
    controller.increaseActionBar()
    if(controller.areTurns()){
      print("At least 1 turn ready\n")
      //change state to turn
      controller.setState(new BeginningTurn)
    }
  }

}
