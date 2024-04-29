package weapon

import character.players.Player
import exceptions.OwnerException

abstract class AbstractWeapon(val name: String, val attack : Int, val weight: Int) extends Weapon{
  
  var owner : Option[Player] = None
  
  def getName : String = name
  def getAttack : Int = attack
  def getWeight : Int = weight
  def getOwner : Option[Player] = owner

  def hasOwner : Boolean = !(owner == None)
 
  //sets owner if weapon doesnt have one
  def setOwner (player : Player) : Unit = {
    if(this.hasOwner) {
      throw OwnerException(s"Weapon $name already has an owner")
    }
    else{
      owner = Some(player)
    }
  }
  
  override def toString : String = {
    s"Weapon($name, $attack, $weight, $owner)"
  }
}
