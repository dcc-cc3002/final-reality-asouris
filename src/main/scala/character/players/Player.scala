package character.players
import character.Character
import weapon.Weapon

trait Player extends Character{
  var equippedWeapon : Option[Weapon]

  def equip(weapon: Weapon): Unit = {
    //exeption
  }

}
