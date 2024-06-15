package controller.states
import controller.GameController

class BeginningTurn extends GameState{

  override def update(controller: GameController): Unit = {
    val character = controller.nextTurn()
    
    if(character.hasEffects){
      character.applyEffects()


      if(character.isDefeated && !character.){
        controller.handlingNewTurn()
      }
      else if(!character.isParalyzed){
        controller.currentTurn = Some(character)
        controller.setState(new ChoosingWeapon())
      }
    }
    else{
      controller.currentTurn = Some(character)
      controller.setState(new ChoosingWeapon())

    }
  }

}
