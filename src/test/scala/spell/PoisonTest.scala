package spell

import character.Enemy
import character.players.WhiteMage
import spells.Poison
import weapon.Wand

class PoisonTest extends munit.FunSuite {
  test("activateSpell should poison the target and decrease the mana of the mage") {
    val mage = new WhiteMage("mage", 20, 20, 20, 20, 40, 40)
    val enemy = new Enemy("enemy", 10, 10, 10, 10, 10)
    val wand = new Wand("wand", 10, 10, 10)
    val poison = new Poison()

    mage.equip(wand)
    poison.activateSpell(enemy, mage)

    val expectedMana = 10

    assert(mage.getMana == expectedMana)

  }

  test("CastByOn test") {
    val mage = new WhiteMage("mage", 20, 20, 20, 20, 40, 40)
    val enemy = new Enemy("enemy", 10, 10, 10, 10, 10)
    val wand = new Wand("wand", 10, 10, 10)
    val poison = new Poison()

    mage.equip(wand)

    poison.castByOn(mage, enemy)

    assert(mage.getMana == 10)

  }
  test("toString test") {
    val poison = new Poison()
    assert(poison.toString == "Poison")
  }


}
