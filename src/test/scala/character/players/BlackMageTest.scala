package character.players

import character.Enemy
import exceptions.SpellException
import spells.{Fire, Thunder}
import weapon.Wand

class BlackMageTest extends munit.FunSuite{
  var BlackMage1: BlackMage = _
  var BlackMage2: BlackMage = _
  var Warrior: Warrior = _

  override def beforeEach(context: BeforeEach): Unit = {
    BlackMage1 = new BlackMage("BlackMage1", 20, 20, 5, 10, 10, 10)
    BlackMage2 = new BlackMage("BlackMage2", 20, 20, 10, 5, 6, 6)
    Warrior = new Warrior("BestWarrior", 20, 20, 20, 5)
  }

  test("equals"){
    assertEquals(BlackMage1, BlackMage1)
    assertEquals(BlackMage1, new BlackMage("BlackMage1", 20, 20, 5, 10, 10, 10))
    assert(!BlackMage1.equals(BlackMage2))
    
    assert(!BlackMage1.equals(Warrior))
  }
  test("Test toString"){
    val expected = "BlackMage(BlackMage1, 20, 20, 5, 10, 10, 10)"
    assert(expected == BlackMage1.toString)
  }

  test("castSpell should activate a spell if is a dark spell and the mage has enough mana") {
    val fire = new Fire()
    val thunder = new Thunder()

    val enemy = new Enemy("enemy", 30, 30, 10, 10, 10)
    val mage = new BlackMage("mage", 30, 30, 40, 50, 50, 50)

    val wand = new Wand("wand", 10, 10, 10)

    mage.equip(wand)

    mage.castFire(enemy)
    assert(mage.getMana == 35)
    assert(enemy.getLife == 20)

    mage.castThunder(enemy)
    assert(mage.getMana == 15)
    assert(enemy.getLife == 10)

    intercept[SpellException] {
      mage.castThunder(enemy)
    }

  }
}