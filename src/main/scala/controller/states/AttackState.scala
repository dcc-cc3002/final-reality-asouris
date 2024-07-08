package controller.states
import controller.GameController
import exceptions.NoneException
import character.Character

/**
 * Represents a state where a character is attacking
 */
class AttackState extends GameState{
  /**
   * Runs an update in the asttackState state
   *
   * @param controller
   */
  override def update(controller: GameController): Unit = {

    var character : Character = null//duplicated code
    
    //different behaviour for players and enemies handled by method.
    controller.currentTurn match {
      case Some(value) => character = value
      case None => throw NoneException("Something went wrong")
    }
    //method implemented by both enemies and players
    character.chooseAndAttackTarget(controller)
    
    controller.setState(new EndingTurn())
  }

}
