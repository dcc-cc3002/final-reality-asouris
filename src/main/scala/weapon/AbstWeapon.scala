package weapon

import character.players.Player
import character.players.traits.WeaponUser

abstract class AbstWeapon(val name: String, val attack : Int, val weight: Int) extends WeaponTrait{
  
  var owner : Option[WeaponUser] = None
  

  def hasOwner : Boolean = !(owner == None)
  

  
  //only accesible by subclasses
  protected def setValidOwner(character : WeaponUser): Unit = {
    owner = Some(character)
  }
  
}
