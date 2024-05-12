package character


abstract class AbstractCharacter(private val name: String, private var life: Int, private var defense: Int, private var weight: Int) extends Character {
  require(name != "")
  require(life >= 1)
  require(defense >= 0)
  require(weight >= 1)

  override def getName : String = name
  override def getLife : Int = life
  override def getDefense : Int = defense
  override def getWeight : Int = weight
  
  def setLife(value: Int) : Unit = {
    require(value >= 0)
    this.life = value
  }

  /** Checks if the player character is defeated.
   *
   * Returns `true` if the player character's life points have reached zero or less, indicating defeat.
   * Returns `false` otherwise.
   *
   * @return `true` if the player character is defeated, `false` otherwise.
   */
  def isDefeated: Boolean = life <= 0

  override def receiveAttack(attackReceived: Int): Unit = {
    val totalAttack = attackReceived - this.getDefense
    val current = this.getLife
    if(totalAttack > 0){
      if (current < totalAttack) {
        this.setLife(0)
      }
      else{
        this.setLife(current - totalAttack)
      }
    }
  }
  
  
}
