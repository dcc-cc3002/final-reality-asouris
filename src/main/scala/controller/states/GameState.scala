package controller.states

import controller.GameController

abstract class GameState {
  
  def update(controller : GameController) : Unit

}
