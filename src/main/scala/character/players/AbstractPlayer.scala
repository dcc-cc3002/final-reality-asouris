package character.players
import weapon.Weapon
import exceptions.{BadBehaviourException, NoneException, WeaponException}
import character.{AbstractCharacter, Character, Enemy}


/**
 * An abstract class representing a player in a game.
 *
 * @param name    The name of the player.
 * @param maxLife     The max amount of life points 
 * @param life    The life points of the player.
 * @param defense The defense points of the player.
 * @param weight  The weight of the player.
 *
 * @constructor Creates a new player character with the specified properties.
 *
 * @author asouris
 */
abstract class AbstractPlayer(name: String, maxLife: Int, life: Int, defense: Int, weight: Int)
  extends AbstractCharacter(name, maxLife, life, defense, weight) with Player {

    private var equippedWeapon : Option[Weapon] = None

    /**
     * Retrieves the currently equipped weapon of the player.
     *
     * @return The equipped weapon.
     * @throws NoneException If the player does not have any weapon equipped.
     */
    def getWeapon: Weapon = {
        equippedWeapon match {
            case Some(value) => value
            case None => throw NoneException("There is no weapon")
        }
    }

    /**
     * Checks if the player has a weapon.
     *
     * @return True if the player has a weapon, false otherwise.
     */
    override def hasWeapon: Boolean = {
        equippedWeapon.isDefined
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
     * Unequipps a weapon by removing the player from being the owner of the weapon, then removing the weapon
     * from the equippedWeapon attribute.
     */
    override def unequipWeapon(): Unit = {
        this.getWeapon.removeOwner()
        equippedWeapon = None
    }

    /**
     * Overrides the attackEnemy method from the Character trait.
     * This method enables the player to attack an Enemy
     *
     * @param enemy The enemy to be attacked.
     * @throws BadBehaviourException If the player does not have any equipped weapon.
     */
    override def attackEnemy(enemy: Enemy): Unit = {
        equippedWeapon match {
            case Some(weapon) => enemy.receiveAttack(weapon.getAttack)
            case None => throw BadBehaviourException("Player with no weapon cannot attack")
        }
    }

    /**
     * Overrides the attackPlayer method from the Character trait.
     * This method throws an exception, since a player cannot attack another player
     *
     * @param player The player to be attacked.
     * @throws BadBehaviourException Since a player cannot attack another player
     */
    override def attackPlayer(player: Player): Unit = {
        throw BadBehaviourException("A player cannot attack another player")
    }

    /**
     * Gets the attack damage of the character based on its weapon.
     *
     * @return The attack of the weapon
     * @throws SpellException if the character does not have a weapon
     */
    override def getAttack: Int = {
        equippedWeapon match{
            case Some(weapon) => weapon.getAttack
            case None => throw NoneException("Cannot get attack from a character with no weapon")
        }
    }

    /**
     * Calculates the actionBar of the player
     *
     * @return The actionBar of the player
     */
    override def getActionBar: Double = {
        equippedWeapon match{
            case Some(weapon) => this.getWeight + 0.5 * weapon.getWeight
            case None => throw NoneException("Cannot get ActionBar of player with no weapon")
        }
    }

    /**
     * Attempts to equip a weapon to the player.
     * By default, this method throws a WeaponException indicating that the player cannot equip the weapon.
     * Subclasses of Player override this method to implement equipping a valid weapon.
     *
     * @param weapon The weapon to be equipped.
     * @throws WeaponException If the player cannot equip the specified weapon.
     */
    def equip(weapon: Weapon): Unit = {
        throw WeaponException(s"$this cannot equip $weapon")
    }




}