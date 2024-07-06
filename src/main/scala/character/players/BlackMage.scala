package character.players

import spells.traits.{DarkSpell, Spell}
import character.players.Player
import weapon.Weapon
import exceptions.{SpellException, WeaponException}
import character.{Character, Enemy}
import spells.{Fire, Thunder}

/** Represents a BlackMage.
  *
  * A BlackMage is a playable character.
  *
  * @param name
  *   The name of the character
  * @param maxLife     
  *   The max amount of life points 
  * @param life
  *   The life of the character
  * @param defense
  *   The defense of the character
  * @param weight
  *   The weight of the character
  * @param mana
  *   The mana of the character
 * @param maxMana
 *    The maximum amount of mana
  *
  * @constructor Creates a new Black Mage character with the specified properties.
  *
  * @author
  *   asouris
  */
class BlackMage(
                 name: String,
                 maxLife: Int,
                 life: Int,
                 defense: Int,
                 weight: Int,
                 mana: Int,
                 maxMana: Int
) extends AbstractMagicPlayer(name, maxLife, life, defense, weight, mana, maxMana) {

  /**
   * Checks whether this black mage is equal to another object.
   *
   * @param other The object to compare with.
   * @return True if the objects are equal, false otherwise.
   */
  override def equals(other: Any): Boolean = {
    other match
      case blackMage1: BlackMage =>
        name == blackMage1.getName && maxLife == blackMage1.getMaxLife && life == blackMage1.getLife && defense == blackMage1.getDefense && weight == blackMage1.getWeight && mana == blackMage1.getMana && maxMana == blackMage1.getMaxMana
      case _ =>
        false
  }

  /**
   * Returns a string representation of this black mage.
   *
   * @return A string representation containing the black mage's properties.
   */
  override def toString: String = {
    s"BlackMage($name, $maxLife, $getLife, $defense, $weight, $getMana, $maxMana)"
  }

  /**
   * Equips a new weapon to the black mage via the method validEquip.
   * This method overrides the one declared in Player.
   *
   * @param newWeapon The weapon to be equipped.
   */
  override def equip(newWeapon: Weapon): Unit = {
    if(newWeapon.isEquippableByBlackMage) {
      super.validEquip(newWeapon.toWeapon)
    }
    else{
      throw WeaponException(s"$this cannot equip $newWeapon")
    }
  }


  /**
   * Casts a Fire spell on the target enemy.
   *
   * @param target The enemy to cast the spell on.
   * @throws SpellException if the spell cannot be cast due to various reasons (e.g., insufficient mana, no weapon equipped).
   */
  def castFire(target: Enemy): Unit = {
    if(this.hasWeapon) {
      if (!target.isDefeated) {
        val fire = new Fire()

        if (fire.getCost <= this.getMana) {
          fire.activateSpell(target, this)
        }
        else {
          throw SpellException("Not enough mana for spell")
        }
      }
      else {
        throw SpellException("Cannot cast spell on dead character")
      }
    }
    else{
      throw SpellException("Cannot cast spells with no weapon")
    }
  }

  /**
   * Attempts to cast a Healing spell on the target.
   *
   * @param target The player to cast the spell on.
   * @throws SpellException as BlackMage cannot use light magic.
   */
  def castHealing(target: Player):Unit = {
    throw SpellException("BlackMage cannot use light magic")
  }

  /**
   * Attempts to cast a Paralysis spell on the target.
   *
   * @param target The enemy to cast the spell on.
   * @throws SpellException as BlackMage cannot use light magic.
   */
  def castParalysis(target: Enemy):Unit = {
    throw SpellException("BlackMage cannot use light magic")
  }

  /**
   * Attempts to cast a Poison spell on the target.
   *
   * @param target The enemy to cast the spell on.
   * @throws SpellException as BlackMage cannot use light magic.
   */
  def castPoison(target: Enemy):Unit = {
    throw SpellException("BlackMage cannot use light magic")
  }

  /**
   * Casts a Thunder spell on the target enemy.
   *
   * @param target The enemy to cast the spell on.
   * @throws SpellException if the spell cannot be cast due to various reasons (e.g., insufficient mana, no weapon equipped).
   */
  def castThunder(target: Enemy):Unit = {
    if(this.hasWeapon) {
      if (!target.isDefeated) {
        val thunder = new Thunder()
        if (thunder.getCost <= this.getMana) {
          thunder.activateSpell(target, this)
        }
        else {
          throw SpellException("Not enough mana for spell")
        }
      }
      else {
        throw SpellException("Cannot cast spell on dead character")
      }
    }
    else{
      throw SpellException("Cannot cast spells with no weapon")
    }
  }

  /**
   * if character is a mage, returns an array with avaible spells
   * return empty array otherwise
   *
   * @param character
   * @return array with spells
   */
  override def getSpells(character: Character): Array[Spell] = {
    Array(Thunder(), Fire())
  }

}
