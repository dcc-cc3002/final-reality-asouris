package weapon
import character.players.Player

/** Represents a weapon
  * @param name
  *   Name of the weapon
  * @param attack
  *   Damage per attack
  * @param weight
  *   Weight of the weapon
  * @param Owner
  *   Owner of the weapon
  *
  * @author
  *   asouris
  */
trait Weapon{
  def getName : String
  
  def getAttack : Int
  
  def getWeight : Int
  
  def hasOwner : Boolean 
  
  def getOwner : Option[Player]
  
  def setOwner(player: Player) : Unit
  
  def toWeapon : Weapon = this
}
