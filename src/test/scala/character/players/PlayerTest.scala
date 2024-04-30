package character.players

import exceptions.WeaponException
import weapon.{Axe, Sword, Wand}

class PlayerTest extends munit.FunSuite {

  var sword: Sword = _
  var axe: Axe = _
  var wand: Wand = _
  var warrior: Warrior = _
  var mage: BlackMage = _

  override def beforeEach(context: BeforeEach): Unit = {
    sword = new Sword("destroyer", 5, 10)
    axe = new Axe("supreme", 4, 15)
    wand = new Wand("ElProgcomp", 10, 10, 20)

    warrior = new Warrior("warrior", 20, 10, 15)
    mage = new BlackMage("mage", 10, 4, 15, 6)

  }

  test("equip throws an exception if a weapon cannot be equip the the character"){
    intercept[WeaponException]{
      warrior.equip(wand)
    }
    intercept[WeaponException]{
      mage.equip(axe)
    }
  }

  test("equip sets equippedWeapon in the character and sets the owner of the weapon if it could be equipped"){
    warrior.equip(axe)
    assert(warrior.equippedWeapon == Some(axe))
    assert(axe.owner == Some(warrior))

    mage.equip(wand)
    assert(mage.equippedWeapon == Some(wand))
    assert(wand.owner == Some(mage))
  }
}
