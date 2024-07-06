package character.players
import spells.traits.{DarkSpell, LightSpell, Spell}
import character.players.Player
import character.{Character, Enemy}
import exceptions.{SpellException, WeaponException}
import spells.{Healing, Paralysis, Poison}
import weapon.Weapon


/** Represents a WhiteMage.
  *
  * A WhiteMage is a playable character.
  *
  * @param name
  *   The name of the character
  * @param maxLife
  *  The max amount of life 
  * @param life
  *   The life of the character
  * @param defense
  *   The defense of the character
  * @param weight
  *   The weight of the character
  * @param mana
  *   The mana of the character
 * @param maxMana
 *    Tha maximum amount of mana
 *    
  * @constructor Creates a new White Mage character with the specified properties.
  * @author
  *   asouris
  */
class WhiteMage(
    name: String,
    maxLife: Int,
    life: Int,
    defense: Int,
    weight: Int,
    mana: Int,
    maxMana: Int
) extends AbstractMagicPlayer(name, maxLife, life, defense, weight, mana, maxMana){

  /**
   * Checks whether this white mage is equal to another object.
   *
   * @param other The object to compare with.
   * @return True if the objects are equal, false otherwise.
   */
  override def equals(other: Any): Boolean = {
    other match
      case whiteMage1: WhiteMage =>
        name == whiteMage1.getName && maxLife == whiteMage1.getMaxLife && life == whiteMage1.getLife && defense == whiteMage1.getDefense && weight == whiteMage1.getWeight && mana == whiteMage1.getMana && maxMana == whiteMage1.getMaxMana
      case _ =>
        false
  }

  /**
   * Returns a string representation of this white mage.
   *
   * @return A string representation containing the white mage's properties.
   */
  override def toString: String = {
    s"WhiteMage($name, $maxLife, $getLife, $defense, $weight, $getMana, $maxMana)"
  }

  /**
   * Equips a new weapon to the white mage via the method validEquip.
   * This method overrides the one declared in Player.
   *
   * @param newWeapon The weapon to be equipped.
   */
  override def equip(newWeapon: Weapon): Unit = {
    if(newWeapon.isEquippableByWhiteMage) {
      super.validEquip(newWeapon.toWeapon)
    }
    else{
      throw WeaponException(s"$this cannot equip $newWeapon")
    }
  }

  /**
   * Attempts to cast a Fire spell on the target.
   *
   * @param target The enemy to cast the spell on.
   * @throws SpellException as WhiteMage cannot use dark magic.
   */
  override def castFire(target: Character): Unit = {
    throw SpellException("WhiteMage cannot use dark magic")
  }

  /**
   * Casts a Healing spell on the target player.
   *
   * @param target The player to cast the spell on.
   * @throws SpellException if the spell cannot be cast due to various reasons (e.g., insufficient mana, no weapon equipped).
   */
  override def castHealing(target: Character): Unit = {
    if(!target.takesSpellDamage) {
      if (this.hasWeapon) {
        if (!target.isDefeated) {
          val healing = new Healing()
          if (healing.getCost <= this.getMana) {
            healing.activateSpell(target, this)
          }
          else {
            throw SpellException("Not enough mana for spell")
          }
        }
        else {
          throw SpellException("Cannot cast spell on dead character")
        }
      }
      else {
        throw SpellException("Cannot cast spells with no weapon")
      }
    }
    else{
      throw SpellException("Cannot cast healing on enemy")
    }
  }

  /**
   * Casts a Paralysis spell on the target enemy.
   *
   * @param target The enemy to cast the spell on.
   * @throws SpellException if the spell cannot be cast due to various reasons (e.g., insufficient mana, no weapon equipped).
   */
  override def castParalysis(target: Character): Unit = {
    if(target.takesSpellDamage) {
      if (this.hasWeapon) {
        if (!target.isDefeated) {
          val paralysis = new Paralysis()
          if (paralysis.getCost <= this.getMana) {
            paralysis.activateSpell(target, this)
          }
          else {
            throw SpellException("Not enough mana for spell")
          }
        }
        else {
          throw SpellException("Cannot cast spell on dead character")
        }
      }
      else {
        throw SpellException("Cannot cast spells with no weapon")
      }
    }
    else{
      throw SpellException("Cannot cast paralysis on ally")
    }
  }

  /**
   * Casts a Poison spell on the target enemy.
   *
   * @param target The enemy to cast the spell on.
   * @throws SpellException if the spell cannot be cast due to various reasons (e.g., insufficient mana, no weapon equipped).
   */
  override def castPoison(target: Character): Unit = {
    if(target.takesSpellDamage) {
      if (this.hasWeapon) {
        if (!target.isDefeated) {
          val poison = new Poison()
          if (poison.getCost <= this.getMana) {
            poison.activateSpell(target, this)
          }
          else {
            throw SpellException("Not enough mana for spell")
          }
        }
        else {
          throw SpellException("Cannot cast spell on dead character")
        }
      }
      else {
        throw SpellException("Cannot cast spells with no weapon")
      }
    }
    else{
      throw SpellException("Cannot cast poison on ally")
    }
  }

  /**
   * Attempts to cast a Thunder spell on the target.
   *
   * @param target The enemy to cast the spell on.
   * @throws SpellException as WhiteMage cannot use dark magic.
   */
  override def castThunder(target: Character): Unit = {
    throw SpellException("WhiteMage cannot use dark magic")
  }

  /**
   * if character is a mage, returns an array with avaible spells
   * return empty array otherwise
   *
   * @param character
   * @return array with spells
   */
  override def getSpells(character: Character): Array[Spell] = {
    Array(Healing(), Paralysis(), Poison())
  }
  

}
