package character

import character.players.AbstractMagicPlayer
import effects.Effect
import exceptions.{BadBehaviourException, NoneException}
import spells.traits.Spell

import scala.collection.mutable.ArrayBuffer
import scala.util.control.Breaks.{break, breakable}

/**
 * An abstract class representing a character in the game.
 *
 * @param name    The name of the character.
 * @param life    The amount of life points the character possesses.
 * @param defense The defense value of the character.
 * @param weight  The weight of the character.
 * @author asouris
 */
abstract class AbstractCharacter(private val name: String, private val maxLife: Int, private var life: Int, private var defense: Int, private var weight: Int) extends Character {
  require(name != "")
  require(life >= 0 && life <= maxLife)
  require(defense >= 0)
  require(weight >= 1)
  require(maxLife >= 1)
  
  private var _paralyzed = false

  private var _team : Option[ArrayBuffer[Character]] = None
  
  var effects : ArrayBuffer[Effect] = new ArrayBuffer[Effect]()

  /**
   * sets characters team in case of battle
   *
   * @param team Array with characters
   */
  override def setTeam(team: ArrayBuffer[Character]): Unit = {
    _team = Some(team)
  }

  /**
   * gets the array with all ally characters
   *
   * @return an array with allies
   */
  def getTeam: ArrayBuffer[Character] = {
    _team match {
      case Some(value) => value
      case None => throw NoneException("No team to return ")
    }
  }
  
  

  /**
   * Retrieves the name of the character.
   *
   * @return The name of the character.
   */
  override def getName : String = name

  /**
   * Retrieves the current life points of the character.
   *
   * @return The current life points of the character.
   */
  override def getLife : Int = life

  /**
   * Retrieves the defense value of the character.
   *
   * @return The defense value of the character.
   */
  override def getDefense : Int = defense

  /**
   * Retrieves the weight of the character.
   *
   * @return The weight of the character.
   */
  override def getWeight : Int = weight

  /**
   * Retrieves the max amount of life of the character.
   *
   * @return The max amount of life of the character.
   */
  override def getMaxLife: Int = maxLife
  
  /**
   * Sets the life points of the character to the specified value.
   *
   * @param value The new value for the character's life points.
   * @throws IllegalArgumentException if the value is negative.
   */
  def setLife(value: Int) : Unit = {
    life += value
    if(life < 0) life = 0
    if(life > maxLife) life = maxLife
  }
  /**
   * Checks if the character is defeated.
   *
   * Returns `true` if the character's life points have reached zero or less, indicating defeat.
   * Returns `false` otherwise.
   *
   * @return `true` if the character is defeated, `false` otherwise.
   */
  def isDefeated: Boolean = life <= 0

  /**
   * Updates the character's life points based on the attack received.
   *
   * If the attack received is greater than the character's defense, the character's life points are reduced accordingly.
   * If not, nothing happens.
   * Also, if the attack is greater than defense life is set to 0.
   * @param attackReceived The amount of attack received.
   */
  override def receiveAttack(attackReceived: Int): Unit = {
    var totalAttack = attackReceived - this.getDefense
    
    val current = getLife
    if(totalAttack > 0){
      print(s"Damage received: $totalAttack\n")
      setLife(- totalAttack)
    }
    else{
      totalAttack = 0
      print(s"Damage received: $totalAttack\n")
      print("Defense too great, attack defended\n")
    }
    
    if(getLife <= 0) print(s"$this died\n")
    
  }

  /**
   * gets returns the instance as a magic player for casting spells.
   *
   * @return instance as magic player
   */
  override def getMage: AbstractMagicPlayer = throw BadBehaviourException(s"$this cannot cast spells")

  /**
   *
   *  @return weather the character has active effects or not
   */
  override def hasEffects: Boolean = effects.nonEmpty

  override def applyEffects(): Unit = {
    print("Character active effects:\n ")
    effects.foreach(effect => print(s"$effect\n"))

    val array = ArrayBuffer[Int]()
    var i = 0
    effects.foreach(effect => {
      if(!effect.apply(this)){
        array += i
      }
      i+=1
    })

    print(s"Result after effects: $this\n")
    
    //removing expired effects
    array.foreach(index => effects.remove(index))
    
    
  }

  /**
   * returns true if the character has active a paralyze effect
   *
   * @return weather the character has active a paralyze effect
   */
  override def isParalyzed: Boolean = _paralyzed

  /**
   * sets the value of attribute paralyzed
   *
   * @param value
   */
  override def setParalyzed(value: Boolean): Unit = {
    _paralyzed = value
  }

  override def addEffect(effect: Effect): Unit = {
    effects += effect
  }

  
}
