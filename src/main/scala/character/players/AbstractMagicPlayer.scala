package character.players

abstract class AbstractMagicPlayer (name: String, life: Int, defense: Int, weight: Int, private var magicPoints: Int)
extends AbstractPlayer(name, life, defense, weight){
  
  def getMagicPoints : Int = magicPoints
  

}
