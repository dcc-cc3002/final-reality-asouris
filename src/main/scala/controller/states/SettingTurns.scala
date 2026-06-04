package controller.states

import controller.GameController

class SettingTurns extends GameState {

  override def update(controller : GameController) : Unit = {
    controller.increaseActionBar()
    if(controller.areTurns()){
      //change state to turn
      controller.setState(new BeginningTurn)
    }
  }

}
