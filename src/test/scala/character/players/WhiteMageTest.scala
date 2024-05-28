package character.players

import character.Enemy
import spells.{Healing, Poison}


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

}
