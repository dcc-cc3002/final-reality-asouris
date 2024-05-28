package spell

import character.Enemy
import character.players.{Warrior, WhiteMage}
import exceptions.SpellException
import spells.{Healing, Poison}
import weapon.Wand

class SpellTest extends munit.FunSuite {

  test("activeSpell throws an exception if the spell cannot affect the target"){
    val mage = WhiteMage("mage", 20, 20, 20, 20, 40, 40)
    val warrior = Warrior("warrior", 15, 5, 5, 5)
    val enemy = new Enemy("enemy", 10, 10, 10, 10, 10)
    val wand = new Wand("wand", 10, 10, 10)
    val poison = new Poison()
    val healing = new Healing()

    mage.equip(wand)

    intercept[SpellException]{
      poison.activateSpell(warrior, mage)
    }

    intercept[SpellException]{
      healing.activateSpell(enemy, mage)
    }

  }

}
