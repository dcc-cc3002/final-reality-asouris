package weapon

import character.players.Player
import exceptions.OwnerException

abstract class AbstractWeapon(private val name: String, private val attack : Int, private val weight: Int) extends Weapon{
  require(name != "")
  require(attack >= 1)
  require(weight >= 1)
  
  private var owner : Option[Player] = None
  
  def getName : String = name
  def getAttack : Int = attack
  def getWeight : Int = weight
  def getOwner : Option[Player] = owner

  def hasOwner : Boolean = owner.isDefined
 
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
