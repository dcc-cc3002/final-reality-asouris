package character.players
import character.Character
import weapon.AbstWeapon
import exceptions.WeaponException


/** Represents a Player
 * 
 * A character that can be controlled by the user
 *
 * @param name The name of the player.
 * @param life The current life of the player.
 * @param defense The defense stat of the player.
 * @param weight The weight of the player.
 * @param weapon The weapon that the player if is carrying one
 *
 * @constructor Creates a new player character with the specified properties.
 *
 * @author asouris
 */
abstract class Player(val name: String, var life: Int, var defense: Int, var weight: Int) extends Character {
    
    var weapon : Option[AbstWeapon] = None
    
    /** Equips a weapon to the player character.
     *
     * @param weapon The weapon to be equipped.
     */
    def equipWeapon(newWeapon : AbstWeapon) : Unit = {
        newWeapon.setOwner(this) match {
            case Some(value) => weapon = Some(newWeapon)
            case None => throw new WeaponException(newWeapon.toString + " could not be assign to " + this.toString)//exception
        }
    }

    /** Checks if the player character is defeated.
     *
     * Returns `true` if the player character's life points have reached zero or less, indicating defeat.
     * Returns `false` otherwise.
     *
     * @return `true` if the player character is defeated, `false` otherwise.
     */
    override def isDefeated: Boolean = life <= 0

}