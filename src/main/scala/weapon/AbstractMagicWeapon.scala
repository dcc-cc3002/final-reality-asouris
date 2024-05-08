package weapon

class AbstractMagicWeapon(name: String, attack : Int, weight: Int, private val magicAttack: Int) 
  extends AbstractWeapon(name, attack, weight){
  require(magicAttack >= 1)
  
  def getMagicAttack : Int = magicAttack

}
