package controller.states

import controller.GameController

class GameState {
  
  def update(controller : GameController) : Unit
  def notify() : Unit

}
