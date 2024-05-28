package spell

import character.Enemy
import character.players.WhiteMage
import spells.Paralysis
import weapon.Wand

class ParalysisTest extends munit.FunSuite {
  test("activateSpell should paralyze the target and decrease the mana of the mage") {
    val mage = new WhiteMage("mage", 20, 20, 20, 20, 40, 40)
    val enemy = new Enemy("enemy", 10, 10, 10, 10, 10)
    val wand = new Wand("wand", 10, 10, 10)
    val paralysis = new Paralysis()

    mage.equip(wand)
    paralysis.activateSpell(enemy, mage)

    val expectedMana = 15

    assert(mage.getMana == expectedMana)

  }


}
