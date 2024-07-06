package controller.states
import controller.GameController
import character.Character
import character.players.Ninja
import exceptions.NoneException
import weapon.Bow
import scala.io.StdIn

class ChoosingWeapon extends GameState{

  override def update(controller: GameController): Unit = {
    //if we got here, we have a character for playing in controller.currentTurn
    var character : Character = null
    controller.currentTurn match {
      case Some(value) => character = value
      case None => throw NoneException("Something went wrong")
    }
    
    //we try to get a weapon set
    controller.getWeapons.get(character) match {
      //if got, then is player
      case Some(array) =>
        //select option
        print(character.toString  + " has 3 weapons available:\n")
        var again = -1
        var selected = -1
        //loop to keep on changing weapon
        while(again != 0){
          //present options
          var i = 1
          array.foreach(weapon => {
            print("(" + i + ") " + weapon + "\n")
            i+=1
          })
          print("Select your choice (1, 2, 3, 4)\n")
          selected = StdIn.readInt()
          
          //ask to continue
          print("Would you like to choose again? (0 or 1)\n")
          again = StdIn.readInt()
        }
        //equip choice. Keep in mind the array only contains eligible weapons for that character.
        //val a = array(selected-1).asInstanceOf[Bow]
        //val b = character.asInstanceOf[Ninja]
        //b.unequipWeapon()
        //b.equip(a)
        character.unequipWeapon()
        character.equip(array(selected-1))
        
        //next state
        controller.setState(new ChoosingAction)
        
      //if nothing, character is enemy
      case None =>
        print("Enemy can only attack\n")
        controller.setState(new AttackState)
    }
  }

}
