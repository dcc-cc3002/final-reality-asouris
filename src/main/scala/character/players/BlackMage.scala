package character.players

import spells.traits.{DarkSpell, Spell}
import character.players.Player
import weapon.traits.EquippableByBlackMage
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
    s"BlackMage($name, $maxLife, $life, $defense, $weight, $mana, $maxMana)"
  }

  /**
   * Equips a new weapon to the black mage via the method validEquip.
   * This method overrides the one declared in Player.
   *
   * @param newWeapon The weapon to be equipped.
   */
  def equip(newWeapon: EquippableByBlackMage): Unit = {
    super.validEquip(newWeapon.toWeapon)
  }


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
  def castHealing(target: Player):Unit = {
    throw SpellException("BlackMage cannot use light magic")
  }
  def castParalysis(target: Enemy):Unit = {
    throw SpellException("BlackMage cannot use light magic")
  }
  def castPoison(target: Enemy):Unit = {
    throw SpellException("BlackMage cannot use light magic")
  }
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

}
