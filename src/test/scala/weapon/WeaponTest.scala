package weapon

import character.players.Player
import character.players.Warrior
import character.players.BlackMage
import weapon.Wand
import weapon.Axe


class WeaponTest extends munit.FunSuite{
  var sword: Sword = _
  var axe: Axe = _
  var wand: Wand = _
  var warrior : Warrior = _
  var mage : BlackMage = _

  override def beforeEach(context: BeforeEach): Unit = {
    sword = new Sword("destroyer", 5, 10)
    axe = new Axe("supreme", 4, 15)
    wand = new Wand("ElProgcomp", 10, 10, 20)

    warrior = new Warrior("warrior", 20, 10, 15)
    mage = new BlackMage("mage", 10, 4, 15, 6)

  }

  test("hasOwner should return true if the weapon has an owner, false if not"){
    assert(!wand.hasOwner)
    mage.equipWeapon(wand)
    assert(wand.hasOwner)
  }

  test("setOwner should return None if the weapon cannot be equipped to that character class"){
    assert(axe.setOwner(mage) == None)
    assert(wand.setOwner(warrior) == None)
  }

  test("setOwner should return the weapon if it could be equipped to the character"){
    assert(axe.setOwner(warrior) == Some(axe))
    assert(wand.setOwner(mage) == Some(wand))
  }
}
