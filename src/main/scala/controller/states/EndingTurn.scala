package controller.states
import controller.GameController

class EndingTurn extends GameState{
  //if we got here that means that the game hasn't finished
  //we only need to figure if we need more turns or not
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
