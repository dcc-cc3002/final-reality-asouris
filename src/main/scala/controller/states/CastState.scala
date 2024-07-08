package controller.states
import character.Character
import character.players.Player
import controller.GameController
import exceptions.NoneException

import scala.io.StdIn

/**
 * Represents a state where a character can cast a spell
 */
class CastState extends GameState{
  /**
   * Runs an update in the castState
   *
   * @param controller
   */
  override def update(controller: GameController): Unit = {
    //choose a spell and target
    var character : Character = null

    controller.currentTurn match {
      case Some(value) => character = value
      case None => throw NoneException("Something went wrong")
    }

    val spells = controller.getSpells(character)

    print("You can cast one of the following spells\n")
    var i = 1
    spells.foreach(spell => {
      print(spell.toString + "("+ i +")\n")
      i+=1
    })
    var selected = StdIn.readInt()
    val spell = spells(selected-1)
    
    val targets  = controller.getSpellTargets(spell, character)
    
    print("Choose your target\n")
    
    i = 1
    targets.foreach(target => {
      if(!target.isDefeated){
        print(target.toString + "(" + i + ")\n" )
      }
      i+=1
    })
    selected = StdIn.readInt()
    val target = targets(selected-1)
    
    spell.castByOn(character, target)
    
    print(spell.toString + " was casted on to " + target.toString + "\n")
    
    controller.setState(new EndingTurn)

  }

}
