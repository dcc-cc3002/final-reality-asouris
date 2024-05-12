package weapon

/**
 * An abstract base class representing a magic weapon.
 *
 * @param name        The name of the magic weapon.
 * @param attack      The attack value of the magic weapon.
 * @param weight      The weight of the magic weapon.
 * @param magicAttack The magic attack value of the magic weapon.
 *                    
 * @author asouris
 */
class AbstractMagicWeapon(name: String, attack : Int, weight: Int, private val magicAttack: Int) 
  extends AbstractWeapon(name, attack, weight){
  require(magicAttack >= 1)

  /**
   * Retrieves the magic attack value of the magic weapon.
   *
   * @return The magic attack value of the magic weapon.
   */
  def getMagicAttack : Int = magicAttack

}
