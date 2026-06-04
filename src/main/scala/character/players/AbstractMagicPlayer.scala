package character.players

/**
 * An abstract class representing a playable character with magical abilities.
 *
 * @param name        The name of the magic player.
 * @param life        The amount of life points the magic player possesses.
 * @param defense     The defense of the magic player.
 * @param weight      The weight of the magic player.
 * @param magicPoints The amount of magic points the magic player possesses.
 *
 * @author asouris
 */
abstract class AbstractMagicPlayer (name: String, life: Int, defense: Int, weight: Int, private var magicPoints: Int)
extends AbstractPlayer(name, life, defense, weight){

  /**
   * Retrieves the current magic points of the magic player.
   *
   * @return The magic points of the player.
   */
  def getMagicPoints : Int = magicPoints
  

}
