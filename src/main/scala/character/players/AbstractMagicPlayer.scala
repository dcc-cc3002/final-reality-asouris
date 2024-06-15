package character.players

import spells.traits.Spell
import exceptions.SpellException
import character.{Character, Enemy}

/**
 * An abstract class representing a playable character with magical abilities.
 *
 * @param name        The name of the magic player.
 * @param maxLife     The max amount of life points 
 * @param life        The amount of life points the magic player possesses.
 * @param defense     The defense of the magic player.
 * @param weight      The weight of the magic player.
 * @param mana        The amount of magic points the magic player possesses.
 * @param maxMana     The maximum amount of mana
 * @author asouris
 */
abstract class AbstractMagicPlayer (name: String, maxLife: Int, life: Int, defense: Int, weight: Int, private var mana: Int, private val maxMana: Int)
extends AbstractPlayer(name, maxLife, life, defense, weight){

  /**
   * Retrieves the current magic points of the magic player.
   *
   * @return The magic points of the player.
   */
  def getMana : Int = mana

  /**
   * Retrieves the maximum magic points of the magic player.
   *
   * @return The maximum magic points of the player.
   */
  def getMaxMana : Int = maxMana

  /**
   * Sets the magic points of the magic player.
   *
   * @param value The value to set the magic points to.
   *              If the resulting magic points exceed the maximum mana, they are capped at maxMana.
   *              If the resulting magic points fall below zero, they are set to zero.
   */
  def setMana(value: Int): Unit = {
    mana += value
    if(mana < 0) mana = 0
    if(mana>maxMana) mana = maxMana
  }

  /**
   * Attempts to cast a Fire spell on the target.
   *
   * @param target The character on whom the spell is to be cast.
   * @throws SpellException as Fire cannot be cast on an ally.
   */
  def castFire(target: Character): Unit = {
    throw SpellException("Cannot cast Fire on ally")
  }

  /**
   * Attempts to cast a Healing spell on the target.
   *
   * @param target The character on whom the spell is to be cast.
   * @throws SpellException as Healing cannot be cast on an enemy.
   */
  def castHealing(target: Character): Unit = {
    throw SpellException("Cannot cast Fire on enemy")
  }

  /**
   * Attempts to cast a Paralysis spell on the target.
   *
   * @param target The character on whom the spell is to be cast.
   * @throws SpellException as Paralysis cannot be cast on an ally.
   */
  def castParalysis(target: Character): Unit = {
    throw SpellException("Cannot cast Fire on ally")
  }

  /**
   * Attempts to cast a Poison spell on the target.
   *
   * @param target The character on whom the spell is to be cast.
   * @throws SpellException as Poison cannot be cast on an ally.
   */
  def castPoison(target: Character): Unit = {
    throw SpellException("Cannot cast Fire on ally")
  }

  /**
   * Attempts to cast a Thunder spell on the target.
   *
   * @param target The character on whom the spell is to be cast.
   * @throws SpellException as Thunder cannot be cast on an ally.
   */
  def castThunder(target: Character): Unit = {
    throw SpellException("Cannot cast Fire on ally")
  }
  
  

}
