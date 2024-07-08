package controller.states
import controller.GameController

/**
 * Represents a state where a character is ending its turn
 */
class EndingTurn extends GameState{
  /**
   * Runs an update in the endingTurn state
   * @param controller
   */
  override def update(controller: GameController): Unit = {
    
    //if there is at least a turn 
    if(controller.areTurns()){
      controller.setState(new BeginningTurn)
    }
    else{
      controller.setState(new SettingTurns)
    }
  }

}
