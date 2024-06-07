package character.players

import character.Enemy
import exceptions.{BadBehaviourException, NoneException, WeaponException}
import weapon.{Axe, Bow, Staff, Sword, Wand}

class PlayerTest extends munit.FunSuite {

  var sword: Sword = _
  var axe: Axe = _
  var bow: Bow = _

  var wand: Wand = _
  var staff: Staff = _

  var warrior: Warrior = _
  var paladin: Paladin = _
  var ninja: Ninja = _
  var mage: BlackMage = _
  var mageWhite: WhiteMage = _

  override def beforeEach(context: BeforeEach): Unit = {
    sword = new Sword("destroyer", 5, 10)
    axe = new Axe("supreme", 4, 15)
    bow = new Bow("regularBow", 30, 2)

    wand = new Wand("ElProgcomp", 10, 10, 20)
    staff = new Staff("regularStaff", 10, 20, 5)

    warrior = new Warrior("warrior", 20, 20, 10, 15)
    paladin = new Paladin("paladin", 20, 20, 10, 15)
    ninja = new Ninja("ninja", 20, 20, 10, 15)

    mage = new BlackMage("mage", 10, 10, 4, 15, 6, 6)
    mageWhite = new WhiteMage("mageWhite", 10, 10, 4, 15, 6, 6)


  }

  test("getWeapon returns the weapon of the playable character or an exception if it didnt had one") {
    warrior.equip(axe)
    assert(warrior.getWeapon == axe)

    intercept[NoneException] {
      paladin.getWeapon
    }
  }

  test("equip throws an exception if a weapon cannot be equip the the character") {
    intercept[WeaponException] {
      warrior.equip(wand)
    }
    intercept[WeaponException] {
      mage.equip(axe)
    }
  }

  test("equip sets equippedWeapon in the character and sets the owner of the weapon if it could be equipped") {
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

  test("A player should be able to unequipped a weapon") {
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


  test("attackEnemy should throw an exception if a player without a weapon tries to attack") {
    var warrior = Warrior("warrior", 20, 20, 10, 5)
    var enemy = Enemy("enemy", 25, 25, 10, 5, 5)

    intercept[BadBehaviourException] {
      warrior.attackEnemy(enemy)
    }
  }

  test("attackCharacter should attack the character by exactly the weapons attack damage") {
    var warrior = Warrior("warrior", 20, 20, 10, 5)
    var enemy = Enemy("enemy", 25, 25, 10, 5, 5)

    warrior.equip(new Axe("axe", 10, 5))

    warrior.attackEnemy(enemy)
    assert(enemy.getLife == 20)

  }
  test("attackCharacter should not make an effect on the character if the defense more o equal to the attack") {
    var warrior = Warrior("warrior", 20, 20, 10, 5)
    var enemy = Enemy("enemy", 25, 25, 10, 15, 5)

    warrior.equip(new Axe("axe", 10, 5))

    assert(enemy.getLife == 25)
    warrior.attackEnemy(enemy)
    assert(enemy.getLife == 25)
  }

  test("attackPlayer throws an exception since an enemy cannot attack another enemy") {
    var warrior0 = Warrior("warrior0", 10, 10, 12, 5)
    var warrior1 = Warrior("warrior1", 15, 15, 4, 2)

    intercept[BadBehaviourException] {
      warrior0.attackPlayer(warrior1)
    }
  }
}



