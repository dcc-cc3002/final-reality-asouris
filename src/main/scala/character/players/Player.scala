package character.players
import character.Character
import exceptions.WeaponException
import weapon.Weapon

trait Player extends Character{
  
  def getWeapon : Weapon
  def equip(weapon: Weapon): Unit = {
    throw WeaponException(s"$this cannot equip $weapon")
  }

}
