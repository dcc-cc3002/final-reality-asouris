package controller.states
import controller.GameController

/**
 * Represents a state where a character starts its turn 
 */
class BeginningTurn extends GameState{

  /**
   * Runs an update in the biginningTurn state
   *
   * @param controller
   */
  override def update(controller: GameController): Unit = {
    //gets next character
    val character = controller.nextTurn()
    //reset its action bar back to 0
    controller.resetActionBar(character)

    print(s"Is $character s turn\n")

    if(character.isParalyzed){
      character.applyEffects()
      controller.setState(new EndingTurn)
    }
    
    //if character is dead
    else if(character.isDefeated){
      controller.setState(new EndingTurn)
    }
    
    //checks for effects
    else if(character.hasEffects){
      
      character.applyEffects()

      //if character died or is paralyzed
      //loses their turn
      if(character.isDefeated || character.isParalyzed) {
        character.setParalyzed(false)
        
        controller.setState(new EndingTurn)
      }
      else{//character just got healing we go forward
        controller.currentTurn = Some(character)
        controller.setState(new ChoosingWeapon())
      }
    }//if no effects and not dead we go forward
    else{
      controller.currentTurn = Some(character)
      controller.setState(new ChoosingWeapon())

    }
  }

}
