package spell

import character.Enemy
import character.players.BlackMage
import spells.Thunder
import weapon.Wand

class ThunderTest extends munit.FunSuite {

  test("activeSpell should decrease the targets life and the mages mana") {
    val enemy = new Enemy("enemy", 10, 10, 10, 10, 10)
    val mage = new BlackMage("mage", 10, 10, 10, 10, 22, 22)
    val wand = new Wand("wand", 5, 5, 5)
    val thunder: Thunder = new Thunder()

    mage.equip(wand)
    thunder.activateSpell(enemy, mage)

    val lifeExpected = 5
    val manaExpected = 2

    assert(enemy.getLife == lifeExpected)
    assert(mage.getMana == manaExpected)
  }
  test("CastByOn test") {
    val enemy = new Enemy("enemy", 10, 10, 10, 10, 10)
    val mage = new BlackMage("mage", 10, 10, 10, 10, 22, 22)
    val wand = new Wand("wand", 5, 5, 5)
    val thunder: Thunder = new Thunder()

    mage.equip(wand)

    thunder.castByOn(mage, enemy)

    val lifeExpected = 5
    val manaExpected = 2

    assert(enemy.getLife == lifeExpected)
    assert(mage.getMana == manaExpected)
  }
  test("toString test") {
    val thunder = new Thunder()
    assert(thunder.toString == "Thunder")
  }
}
