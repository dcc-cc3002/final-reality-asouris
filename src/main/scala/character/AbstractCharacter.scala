package character


abstract class AbstractCharacter(val name: String, var life: Int, var defense: Int, var weight: Int) extends Character {
  
  def getName : String = name
  def getLife : Int = life
  def getDefense : Int = defense
  def getWeight : Int = weight
  
  override def toString : String = {
    s"Character($name, $life, $defense, $weight)"
  }

  /** Checks if the player character is defeated.
   *
   * Returns `true` if the player character's life points have reached zero or less, indicating defeat.
   * Returns `false` otherwise.
   *
   * @return `true` if the player character is defeated, `false` otherwise.
   */
  def isDefeated: Boolean = life <= 0

}
