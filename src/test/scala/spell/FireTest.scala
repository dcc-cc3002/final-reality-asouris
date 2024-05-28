package spell

import character.Enemy
import character.players.BlackMage
import spells.Fire
import weapon.Wand

class FireTest extends munit.FunSuite{

  test("activeSpell should decrease the targets life and the mages mana"){
    val enemy = new Enemy("enemy", 10, 10, 10, 10, 10)
    val mage = new BlackMage("mage", 10, 10, 10, 10, 22, 22)
    val wand = new Wand("wand", 5, 5, 5)
    val fire: Fire = new Fire()

    mage.equip(wand)
    fire.activateSpell(enemy, mage)

    val lifeExpected = 5
    val manaExpected = 7

    assert(enemy.getLife == lifeExpected)
    assert(mage.getMana == manaExpected)

  }
}
