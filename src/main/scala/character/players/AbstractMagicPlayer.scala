package character.players

abstract class AbstractMagicPlayer (name: String, life: Int, defense: Int, weight: Int, var magicPoints: Int)
extends AbstractPlayer(name, life, defense, weight){
  
  def getMagicPoints : Int = magicPoints

  override def toString: String = {
    s"Magic Character($name, $life, $defense, $weight, $magicPoints)"
  }

}
