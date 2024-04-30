package character.players
import weapon.Weapon
import exceptions.NoneException
import character.AbstractCharacter


/** Represents a Player
 * 
 * A character that can be controlled by the user
 *
 * @param name The name of the player.
 * @param life The current life of the player.
 * @param defense The defense stat of the player.
 * @param weight The weight of the player.
 *
 * @constructor Creates a new player character with the specified properties.
 *
 * @author asouris
 */
abstract class AbstractPlayer(name: String, life: Int, defense: Int, weight: Int)
  extends AbstractCharacter(name, life, defense, weight) with Player {

    var equippedWeapon : Option[Weapon] = None
    
    def getWeapon: Weapon = {
        equippedWeapon match{
            case Some(weapon) => weapon
            case None => throw NoneException("Weapon is None")
        }
    }

    protected def validEquip(weapon: Option[Weapon]): Unit = {
        weapon match {
            case Some(newWeapon) => 
                equippedWeapon = Some(newWeapon)
                newWeapon.setOwner(this)
            
            case None => throw NoneException("Weapon is None")
        }
        
        
    }



}