package spell

import character.players.{BlackMage, Warrior, WhiteMage}
import spells.Healing
import weapon.Wand

class HealingTest extends munit.FunSuite {

  test("activeSpell should increase the targets life by 30% of their maximum life and decrease the mages mana"){
    val mage = new BlackMage("mage", 20, 20, 20, 20, 20, 20)
    val warrior = new Warrior("warrior", 15, 5, 5, 5)
    val wand = new Wand("wand", 10, 5, 10)
    val spell = new Healing()

    mage.equip(wand)
    spell.activateSpell(warrior, mage)

    val expectedLife = 5 + (15*0.3).toInt
    val expectedMana = 5

    assert(warrior.getLife == expectedLife)
    assert(mage.getMana == expectedMana)
  }

  test("CastByOn test") {
    val mage = new WhiteMage("mage", 20, 20, 20, 20, 20, 20)
    val warrior = new Warrior("warrior", 15, 5, 5, 5)
    val wand = new Wand("wand", 10, 5, 10)
    val spell = new Healing()

    mage.equip(wand)

    spell.castByOn(mage, warrior)

    val expectedLife = 5 + (15*0.3).toInt

    assert(warrior.getLife == expectedLife)

  }
  test("toString test") {
    val healing = new Healing()
    assert(healing.toString == "Healing")
  }
  

}
