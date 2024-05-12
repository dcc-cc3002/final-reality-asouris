package character.players
import weapon.Weapon
import exceptions.NoneException
import character.AbstractCharacter
import character.Character


/**
 * An abstract class representing a player in a game.
 *
 * @param name    The name of the player.
 * @param life    The life points of the player.
 * @param defense The defense points of the player.
 * @param weight  The weight of the player.
 *
 * @constructor Creates a new player character with the specified properties.
 *
 * @author asouris
 */
abstract class AbstractPlayer(name: String, life: Int, defense: Int, weight: Int)
  extends AbstractCharacter(name, life, defense, weight) with Player {

    private var equippedWeapon : Option[Weapon] = None

    /**
     * Retrieves the currently equipped weapon of the player.
     *
     * @return The equipped weapon.
     * @throws NoneException If the player does not have any weapon equipped.
     */
    def getWeapon: Weapon = {
        equippedWeapon match{
            case Some(weapon) => weapon
            case None => throw NoneException("Weapon is None")
        }
    }

    /**
     * Equips a valid weapon for the player.
     * This method equips a weapon previously validated to the character. It also sets the weapon's owner
     *
     * @param weapon The new weapon to be equipped.
     */
    protected def validEquip(weapon: Weapon): Unit = {
        equippedWeapon = Some(weapon)
        weapon.setOwner(this)
    }

    /**
     * Overrides the attackCharacter method from the Character trait.
     * This method enables the player to attack another character.
     *
     * @param character The character to be attacked.
     * @throws NoneException If the player does not have any equipped weapon.
     */
    override def attackCharacter(character: Character): Unit = {
        equippedWeapon match {
            case Some(weapon) => character.receiveAttack(weapon.getAttack)
            case None => throw NoneException("Player with no weapon cannot attack")
        }
    }



}