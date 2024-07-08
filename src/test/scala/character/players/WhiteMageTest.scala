package character.players

import character.Enemy
import exceptions.SpellException
import spells.traits.Spell
import spells.{Healing, Poison, Paralysis}
import weapon.Wand


class WhiteMageTest extends munit.FunSuite{
  var WhiteMage1: WhiteMage = _
  var WhiteMage2: WhiteMage = _
  var Warrior : Warrior = _

  override def beforeEach(context: BeforeEach): Unit = {
    WhiteMage1 = new WhiteMage("whiteMage1", 20, 20, 5, 10, 5, 5)
    WhiteMage2 = new WhiteMage("whiteMage2", 20, 20, 10, 5, 15, 15)
    Warrior = new Warrior("BestWarrior", 20, 20, 20, 5)
  }

  test("equals"){
    assertEquals(WhiteMage1, WhiteMage1)
    assertEquals(WhiteMage1, new WhiteMage("whiteMage1", 20, 20, 5, 10, 5, 5))
    assert(!WhiteMage1.equals(WhiteMage2))
    
    assert(!WhiteMage1.equals(Warrior))
  }
  test("Test toString") {
    val expected = "WhiteMage(whiteMage1, 20, 20, 5, 10, 5, 5)"
    assert(expected == WhiteMage1.toString)
  }

  test("castSpell should activate a spell if the mage has enough mana"){
    val enemy = new Enemy("enemy", 10, 10, 10, 10, 10)
    val mage = new WhiteMage("mage", 30, 30, 40, 50, 50, 50)

    val wand = new Wand("wand", 10, 10, 10)

    mage.equip(wand)

    mage.castPoison(enemy)
    assert(mage.getMana == 20)

    Warrior.setLife(-10)

    mage.castHealing(Warrior)
    assert(Warrior.getLife == 16)
    assert(mage.getMana == 5)
    
    mage.setMana(mage.getMaxMana)
    
    mage.castParalysis(enemy)
    assert(mage.getMana == 25)
    
    mage.setMana(-mage.getMana)
    
    //mage does not have enough mana for this
    
    intercept[SpellException]{
      mage.castParalysis(enemy)
    }
    intercept[SpellException]{
      mage.castPoison(enemy)
    }
    intercept[SpellException] {
      mage.castHealing(Warrior)
    }
    
    
    
    //mage cannot cast this
    intercept[SpellException] {
      mage.castFire(enemy)
    }
    intercept[SpellException]{
      mage.castThunder(enemy)
    }
    

  }


  

}
