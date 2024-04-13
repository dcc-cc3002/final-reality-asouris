package party
import scala.util.control.Breaks._
import scala.collection.mutable.ArrayBuffer
import character.players.Player

/** Represents a party of playable characters.
 *
 * A party is a group of characters that work together.
 *
 * @constructor Creates a new party with an empty list of members.
 * 
 * @author asouris
 * 
 */
class Party (){

  /** Members of the Party */
  private val members: ArrayBuffer[Player] = new ArrayBuffer[Player]()

  /** Adds a character to the party.
   *
   * @param newMember The character to be added to the party.
   */
  def addCharacter(newMember: Player): Unit = {
    members.addOne(newMember)
  }

  /** Checks if all members of the party are defeated.
   *
   * Returns `true` if all members of the party are defeated.
   * Returns `false` if at least one member of the party is not defeated.
   *
   * @return `true` if the party is defeated, `false` otherwise.
   */
  def isDefeated: Boolean = {
    var result = true
    breakable{
      for (member <- members) {
        if (!member.isDefeated ){
          result = false
          break
        }
      }
    }
    return result
  }

}
