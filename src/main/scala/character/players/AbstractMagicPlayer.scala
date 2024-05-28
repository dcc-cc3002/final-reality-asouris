package character.players

import spells.traits.Spell
import exceptions.SpellException

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
  
  def getMaxMana : Int = maxMana
  
  def setMana(value: Int): Unit = {
    mana += value
    if(mana < 0) mana = 0
    if(mana>maxMana) mana = maxMana
  }
  
  def castSpell(spell : Spell, target : Player): Unit = {
    throw SpellException(s"$this cannot cast $spell")
  }
  

}
