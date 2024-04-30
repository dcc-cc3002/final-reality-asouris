package weapon


import character.players.Warrior
import character.players.BlackMage
import exceptions.OwnerException



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
    mage.equip(wand)
    assert(wand.hasOwner)
  }

  test("setOwner should set the owner of the weapon if there inst any") {
    assert(sword.owner.isEmpty)
    sword.setOwner(warrior)
    assert(sword.owner == Some(warrior))
  }

  test("setOwner should throw an exception when trying to set an owner to a weapon with owner"){
    sword.setOwner(warrior)
    intercept[OwnerException]{
      sword.setOwner(mage)
    }
  }

}
