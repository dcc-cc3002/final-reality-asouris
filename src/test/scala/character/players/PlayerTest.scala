package character.players

import exceptions.{NoneException, WeaponException}
import weapon.{Axe, Bow, Staff, Sword, Wand}

class PlayerTest extends munit.FunSuite {

  var sword: Sword = _
  var axe: Axe = _
  var bow: Bow = _
  
  var wand: Wand = _
  var staff : Staff = _
  
  var warrior: Warrior = _
  var paladin: Paladin = _
  var ninja : Ninja = _
  var mage: BlackMage = _
  var mageWhite : WhiteMage = _

  override def beforeEach(context: BeforeEach): Unit = {
    sword = new Sword("destroyer", 5, 10)
    axe = new Axe("supreme", 4, 15)
    bow = new Bow("regularBow", 30, 2)
    
    wand = new Wand("ElProgcomp", 10, 10, 20)
    staff = new Staff("regularStaff", 10, 20, 5)

    warrior = new Warrior("warrior", 20, 10, 15)
    paladin = new Paladin("paladin", 20, 10, 15)
    ninja = new Ninja("ninja", 20, 10, 15)
    
    mage = new BlackMage("mage", 10, 4, 15, 6)
    mageWhite = new WhiteMage("mageWhite", 10, 4, 15, 6)
    

  }
  
  test("getWeapon returns the weapon of the playable character or an exception if it didnt had one"){
    warrior.equip(axe)
    assert(warrior.getWeapon == axe)
    
    intercept[NoneException]{
      paladin.getWeapon
    }
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
    assert(warrior.getWeapon == axe)
    assert(axe.getOwner == warrior)

    mage.equip(wand)
    assert(mage.getWeapon == wand)
    assert(wand.getOwner == mage)

    mageWhite.equip(staff)
    assert(mageWhite.getWeapon == staff)
    assert(staff.getOwner == mageWhite)

    paladin.equip(sword)
    assert(paladin.getWeapon == sword)
    assert(sword.getOwner == paladin)

    ninja.equip(bow)
    assert(ninja.getWeapon == bow)
    assert(bow.getOwner == ninja)
  }

  test("A player should be able to unequipped a weapon"){
    warrior.equip(axe)
    assert(warrior.getWeapon == axe)

    warrior.unequipWeapon()

    assert(!warrior.hasWeapon)
    assert(!axe.hasOwner)
  }

  test("hasWeapon should return true if the player has an weapon, false if not") {
    assert(!mage.hasWeapon)
    mage.equip(wand)
    assert(mage.hasWeapon)
  }
}
