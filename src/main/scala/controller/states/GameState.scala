package controller.states

import controller.GameController

/**
 * Represents a state of the game
 */
abstract class GameState {
  /**
   * Runs an update in the state
   *
   * @param controller
   */
  def update(controller : GameController) : Unit

}
