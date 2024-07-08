package controller.states

import controller.GameController

/**
 * Represents a state where the controller its setting the next turns
 */
class SettingTurns extends GameState {

  /**
   * Runs an update in the settingTurns state
   * @param controller
   */
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
