package party
import scala.util.control.Breaks.*
import scala.collection.mutable.ArrayBuffer
import character.players.Player
import exceptions.BadBehaviourException

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
  
  def getMembers : ArrayBuffer[Player] = {
    this.members  
  }

  /** Adds a character to the party only if there are 2 members or less.
   *
   * @param newMember The character to be added to the party.
   * @throws BadBehaviourException If trying to add a fourth member
   */
  def addCharacter(newMember: Player): Unit = {
    if(members.length >= 3){
      throw BadBehaviourException("A party cannot have more than 3 members")
    }
    else{
      members.addOne(newMember)
    }
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

  /** Compares this party with another party for equality.
   *
   * Two parties are considered equal if they have the same number of members
   * and all members in both parties are equal.
   *
   * @param other The object to compare with this party.
   * @return `true` if the parties are equal, `false` otherwise.
   */
  override def equals(other: Any): Boolean = {
    other match
      case party1: Party =>
        // Check if both parties have the same number of members
        if (members.length != party1.members.length) {
          false
        } else {
          // Check if all members in both parties are equal
          this.members.zip(party1.members).forall { case (m1, m2) => m1 == m2 }
        }
      case _ =>
        false
  }

  /** Returns a string representation of the party.
   *
   * The string representation contains the list of members of the party.
   *
   * @return A string representation of the party.
   */
  override def toString: String = {
    s"Party(${members.mkString(", ")})"
  }

}
